package fracCalc;
import java.util.*;

/* This class is the client code for the Fraction class.
 * This program uses the Fraction object to do various operations (addition, subtraction, multiplication, and division) with two given fractions. 
 * 
 * @author Douglas Hong
 * @version 1/23/2019
 */

public class FracCalc {
	//the main method handles the userInput and prints out the output from produceAnswer
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please type the first operand (fraction), the operator (+,-,*,/), and the second operand (fraction) (Type 'quit' to quit)");
        String expression = userInput.nextLine();
        while(!expression.equalsIgnoreCase("quit")) {
        	System.out.println(produceAnswer(expression));
        	System.out.println("Please type the first operand(fraction), the operator (+,-,*,/), and the second operand (fraction) (Type 'quit' to quit)");
        	expression = userInput.nextLine();
        }
        System.out.println("Calculator stopped");
    }
    //produceAnswer parses the operands in the user's input, does the operations with them, and returns a String mixed number
    public static String produceAnswer(String input) { 
    	String[] splitInput = input.split(" ");
    	String firstOperand = splitInput[0];
    	String secondOperand = splitInput[2];
    	String operator = splitInput[1];
    	Fraction operand1 = new Fraction(firstOperand);
    	Fraction operand2 = new Fraction(secondOperand);
    	//Fraction answer = new Fraction();
    	String answer = operand1.doMath(operator, operand2);
    	return answer;
    }
    //gets the operand and parses the whole number, numerator, and denominator to integers
    public static int[] makeRealFraction(String operand) {
    	int[] realFrac = {0, 0, 1};
    	if(operand.contains("_")) {
    		String[] wholeAndFrac = operand.split("_");
    		realFrac[0] = Integer.parseInt(wholeAndFrac[0]);
    		operand = wholeAndFrac[1];
    	}
    	if(operand.contains("/")) {
    		String[] numAndDenom = operand.split("/");
    		realFrac[1] = Integer.parseInt(numAndDenom[0]);
    		realFrac[2] = Integer.parseInt(numAndDenom[1]);
    	}else {
    		realFrac[0] = Integer.parseInt(operand);
    	}
    	return realFrac;
    }
    //creates an improper fraction using the operand's whole number, numerator, and denominator
    public static int[] toImproperFrac(int[] operand) {
    	int[] improper = new int[2];
    	if(operand[0] >= 0) {
    		improper[0] = operand[0]*operand[2]+operand[1];
    	}else {
    		improper[0] = operand[0]*operand[2]-operand[1];
    	}
       	improper[1] = operand[2];
    	return improper;
    }
    //adds two improper fractions together and returns an improper fraction
    public static int[] add(int[] frac1, int[] frac2) {
    	int[] sum = new int[2];
    	int gcf = gcf(frac1[1], frac2[1]);
        frac1[0] *= (gcf/frac1[1]);
        frac2[0] *= (gcf/frac2[1]);
    	sum[0] = frac1[0] + frac2[0];
    	sum[1] = gcf;
    	return sum;
    }
    //subtracts two improper fractions and returns an improper fraction
    public static int[] subtract(int[] frac1, int[] frac2) {
    	int[] difference = new int[2];
    	int gcf = gcf(frac1[1], frac2[1]);
    	frac1[0] *= (gcf/frac1[1]);
        frac2[0] *= (gcf/frac2[1]);
    	difference[0] = frac1[0] - frac2[0];
    	difference[1] = gcf;
    	return difference;
    }
    //multiplies two improper fractions and returns an improper fraction
    public static int[] multiply(int[] frac1, int[] frac2) {
    	int[] product = new int[2];
    	product[0] = frac1[0] * frac2[0];
    	product[1] = frac1[1] * frac2[1];
    	return product;
    }
    //divides two improper fractions and returns an improper fraction
    public static int[] divide(int[] frac1, int[] frac2) {
    	int[] quotient = new int[2];
    	quotient[0] = frac1[0] * frac2[1];
    	quotient[1] = frac1[1] * frac2[0];
    	return quotient;
    }
    //determines the greatest common factor of two integers
  	public static int gcf(int num1, int num2) {
  		return num1 * num2;
  	}
  	//reduces the fraction by finding the least common denominator and dividing the numbers by that number
  	public static void reduce(int[] frac) {
  		int greaterNum;
  		//uses absolute value so it also works with negative numbers
  		if(absValue(frac[0]) > absValue(frac[1])) {
  			greaterNum = absValue(frac[0]);
  		}else {
  			greaterNum = absValue(frac[1]);
  		}
  		for(int i = greaterNum; i > 1; i--) {
  			if(isDivisibleBy(absValue(frac[0]), i) && isDivisibleBy(absValue(frac[1]), i)) {
  				frac[0] /= i;
  				frac[1] /= i;
  			}
  		}
  	}
  	//returns the absolute value of the number passed
  	public static int absValue(int number) {
  		if(number < 0) {
  			return number*-1;
  		}else {
  			return number;
  		}
  	}
    //determines if a number is evenly divisible by another number
  	public static boolean isDivisibleBy(int num1, int num2) {
  		if(num1 % num2 == 0) {
  			return true;
  		}else {
  			return false;
  		}
  	}
    //converts an improper fraction to a mixed number 
  	public static String toMixedNum(int[] improperFrac) {
  		String mixedNum = improperFrac[0]/improperFrac[1] + "_" + (improperFrac[0]%improperFrac[1]) + "/" + improperFrac[1];
  		//gets rid of numerator and denominator if numerator = 0
  		if(mixedNum.substring(mixedNum.indexOf("_") + 1).startsWith("0")) {
  			mixedNum = mixedNum.substring(0, mixedNum.indexOf("_"));
  		}
  		//gets rid of 0 as whole number
  		if(mixedNum.startsWith("0")) { 
  			mixedNum = mixedNum.substring(mixedNum.indexOf("_") + 1, mixedNum.length());
  		}
  		//formats the mixed number by getting rid of improper negative signs in the numerator and/or denominator
  		if(improperFrac[0] < 0 && improperFrac[1] < 0 && mixedNum.indexOf("_") != -1) {
  			mixedNum = improperFrac[0]/improperFrac[1] + "_" + (improperFrac[0]%improperFrac[1])*-1 + "/" + improperFrac[1]*-1;
  		}else if(improperFrac[0] < 0 && improperFrac[1] > 0 && mixedNum.indexOf("_") != -1) {
  			mixedNum = improperFrac[0]/improperFrac[1] + "_" + (improperFrac[0]%improperFrac[1])*-1 + "/" + improperFrac[1];
  		}else if(improperFrac[0] > 0 && improperFrac[1] < 0 && mixedNum.indexOf("_") != -1) {
  			mixedNum = improperFrac[0]/improperFrac[1] + "_" + (improperFrac[0]%improperFrac[1]) + "/" + improperFrac[1]*-1;
  		}else if(improperFrac[1] < 0 && mixedNum.indexOf("_") == -1 && mixedNum.indexOf("/") != -1) { 
  			mixedNum = (improperFrac[0]%improperFrac[1])*-1 + "/" + improperFrac[1]*-1;
  		}
  		return mixedNum;
  	}
}