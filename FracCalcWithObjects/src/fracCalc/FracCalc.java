package fracCalc;
import java.util.*;

/* This class is the client code for the Fraction class.
 * This program uses the Fraction object to do various operations (addition, subtraction, multiplication, and division) with two given fractions. 
 * 
 * @author Douglas Hong
 * @version 1/23/2019
 */

public class FracCalc {
	//the main method gets the userInput and prints out the output from produceAnswer
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
    //produceAnswer makes instances of Fraction, does operations, and returns a String mixed number
    public static String produceAnswer(String input) { 
    	String[] splitInput = input.split(" ");
    	Fraction firstOperand = new Fraction(splitInput[0]);
    	Fraction secondOperand = new Fraction(splitInput[2]);
    	String operator = splitInput[1];
    	Fraction answer = firstOperand.doMath(operator, secondOperand);
    	return answer.toString();
    }
}