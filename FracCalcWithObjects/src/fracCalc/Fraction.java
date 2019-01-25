package fracCalc;
import java.util.*;
public class Fraction {
	private int wholeNum;
	private int numerator;
	private int denominator;
	private int sign;
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
		sign = 1;
	}
	public void toImproperFrac() {
    	if(wholeNum >= 0) {
    		numerator = (wholeNum*denominator+numerator);
    	}else {
    		numerator = (wholeNum*denominator-numerator);
    	}
    	wholeNum = 0;
    }
	public String doMath(String operator, Fraction operand) {
		int gcf = gcf(denominator, operand.getDenominator());
		if(operator.equals("+")) {
	    	numerator = (numerator *(gcf/denominator)) + (operand.getNumerator()*(gcf/operand.getDenominator()));
	    	denominator = gcf;
		}else if(operator.equals("-")) {
			numerator = (numerator *(gcf/denominator)) - (operand.getNumerator()*(gcf/operand.getDenominator()));
	    	denominator = gcf;
		}else if(operator.equals("*")) {
			numerator *= operand.getNumerator();
			denominator *= operand.getDenominator();
		}else {
			numerator *= operand.getDenominator();
			denominator *= operand.getNumerator();
		}
		reduce();
		return toMixedNum();
	}
	public String toString() {
		return wholeNum + "_" + numerator + "/" + denominator;
	}
	//determines the greatest common factor of two integers
  	public int gcf(int num1, int num2) {
  		return num1 * num2;
  	}
  	//reduces the fraction by finding the least common denominator and dividing the numbers by that number
  	public void reduce() {
  		int greaterNum;
  		//uses absolute value so it also works with negative numbers
  		if(absValue(numerator) > absValue(denominator)) {
  			greaterNum = absValue(numerator);
  		}else {
  			greaterNum = absValue(denominator);
  		}
  		for(int i = greaterNum; i > 1; i--) {
  			if(isDivisibleBy(absValue(numerator), i) && isDivisibleBy(absValue(denominator), i)) {
  				numerator /= i;
  				denominator /= i;
  			}
  		}
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
  	public String toMixedNum() {
  		String mixedNum = numerator/denominator + "_" + (numerator%denominator) + "/" + denominator;
  		//gets rid of numerator and denominator if numerator = 0
  		if(mixedNum.substring(mixedNum.indexOf("_") + 1).startsWith("0")) {
  			mixedNum = mixedNum.substring(0, mixedNum.indexOf("_"));
  		}
  		//gets rid of 0 as whole number
  		if(mixedNum.startsWith("0")) { 
  			mixedNum = mixedNum.substring(mixedNum.indexOf("_") + 1, mixedNum.length());
  		}
  		//formats the mixed number by getting rid of improper negative signs in the numerator and/or denominator
  		if(numerator < 0 && denominator < 0 && mixedNum.indexOf("_") != -1) {
  			mixedNum = numerator/denominator + "_" + (numerator%denominator)*-1 + "/" + denominator*-1;
  		}else if(numerator < 0 && denominator > 0 && mixedNum.indexOf("_") != -1) {
  			mixedNum = numerator/denominator + "_" + (numerator%denominator)*-1 + "/" + denominator;
  		}else if(numerator > 0 && denominator < 0 && mixedNum.indexOf("_") != -1) {
  			mixedNum = numerator/denominator + "_" + (numerator%denominator) + "/" + denominator*-1;
  		}else if(denominator < 0 && mixedNum.indexOf("_") == -1 && mixedNum.indexOf("/") != -1) { 
  			mixedNum = (numerator%denominator)*-1 + "/" + denominator*-1;
  		}
  		return mixedNum;
  	}
	public int getWholeNum() {
		return wholeNum;
	}
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
}
