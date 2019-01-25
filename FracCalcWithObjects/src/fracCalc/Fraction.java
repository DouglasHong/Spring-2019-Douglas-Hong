package fracCalc;
import java.util.*;

/* This class contains the Fraction object, which holds the values in a fraction and does various operations.
 * 
 * @author Douglas Hong
 * @version 1/23/2019
 */

public class Fraction {
	private int wholeNum;
	private int numerator;
	private int denominator;
	public Fraction(String operand) {
    	if(operand.contains("_")) {
    		String[] wholeAndFrac = operand.split("_");
    		wholeNum = Integer.parseInt(wholeAndFrac[0]);
    		operand = wholeAndFrac[1];
    	}
    	if(operand.contains("/")) {
    		String[] numAndDenom = operand.split("/");
    		numerator = Integer.parseInt(numAndDenom[0]);
    		denominator = Integer.parseInt(numAndDenom[1]);
    	}else {
    		wholeNum = Integer.parseInt(operand);
    		denominator = 1;
    	}
    	toImproperFrac();
	}
	public Fraction() {
		wholeNum = 0;
		numerator = 0;
		denominator = 1;
	}
	public void toImproperFrac() {
    	if(wholeNum >= 0) {
    		numerator = (wholeNum*denominator+numerator);
    	}else {
    		numerator = (wholeNum*denominator-numerator);
    	}
    	wholeNum = 0;
    }
	public Fraction doMath(String operator, Fraction operand) {
		Fraction answer = new Fraction();
		int gcf = gcf(denominator, operand.denominator);
		if(operator.equals("+")) {
	    	answer.numerator = (numerator *(gcf/denominator)) + (operand.numerator*(gcf/operand.denominator));
	    	answer.denominator = gcf;
		}else if(operator.equals("-")) {
			answer.numerator = (numerator *(gcf/denominator)) - (operand.numerator*(gcf/operand.denominator));
	    	answer.denominator = gcf;
		}else if(operator.equals("*")) {
			answer.numerator = numerator * operand.numerator;
			answer.denominator = denominator * operand.denominator;
		}else {
			answer.numerator = numerator * operand.denominator;
			answer.denominator = denominator * operand.numerator;
		}
		answer = reduce(answer);
		return toMixedNum(answer);
	}
	public String toString() {
		//gets rid of numerator and denominator if numerator = 0
		String output = wholeNum + "_" + numerator + "/" + denominator;
		if(output.substring(output.indexOf("_") + 1).startsWith("0")) {
  			output = output.substring(0, output.indexOf("_"));
  		}
		//gets rid of 0 as whole number
  		if(output.startsWith("0")) { 
  			output = output.substring(output.indexOf("_") + 1, output.length());
  		}
  		//formats the mixed number by getting rid of improper negative signs in the numerator and/or denominator
  		if(numerator < 0 && denominator < 0 && output.indexOf("_") != -1) {
  			output = numerator/denominator + "_" + (numerator%denominator)*-1 + "/" + denominator*-1;
  		}else if(numerator < 0 && denominator > 0 && output.indexOf("_") != -1) {
  			output = numerator/denominator + "_" + (numerator%denominator)*-1 + "/" + denominator;
  		}else if(numerator > 0 && denominator < 0 && output.indexOf("_") != -1) {
  			output = numerator/denominator + "_" + (numerator%denominator) + "/" + denominator*-1;
  		}else if(denominator < 0 && output.indexOf("_") == -1 && output.indexOf("/") != -1) { 
  			output = (numerator%denominator)*-1 + "/" + denominator*-1;
  		}
		return output;
	}
	//determines the greatest common factor of two integers
  	public int gcf(int num1, int num2) {
  		return num1 * num2;
  	}
  	//reduces the fraction by finding the least common denominator and dividing the numbers by that number
  	public Fraction reduce(Fraction frac) {
  		Fraction reducedFrac = frac;
  		int greaterNum;
  		//uses absolute value so it also works with negative numbers
  		if(absValue(reducedFrac.numerator) > absValue(reducedFrac.denominator)) {
  			greaterNum = absValue(reducedFrac.numerator);
  		}else {
  			greaterNum = absValue(reducedFrac.denominator);
  		}
  		for(int i = greaterNum; i > 1; i--) {
  			if(isDivisibleBy(absValue(reducedFrac.numerator), i) && isDivisibleBy(absValue(reducedFrac.denominator), i)) {
  				reducedFrac.numerator /= i;
  				reducedFrac.denominator /= i;
  			}
  		}
  		return reducedFrac;
  	}
  	//returns the absolute value of the number passed
  	public int absValue(int number) {
  		if(number < 0) {
  			return number*-1;
  		}else {
  			return number;
  		}
  	}
    //determines if a number is evenly divisible by another number
  	public boolean isDivisibleBy(int num1, int num2) {
  		if(num1 % num2 == 0) {
  			return true;
  		}else {
  			return false;
  		}
  	}
    //converts an improper fraction to a mixed number 
  	public Fraction toMixedNum(Fraction frac) {
  		Fraction mixedNum = frac;
  		mixedNum.wholeNum = numerator/denominator;
  		mixedNum.numerator = numerator%denominator;
  		return mixedNum;
  	}
}
