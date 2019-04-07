package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

/* This is the client code for TextExcel. It uses a while loop to execute the prompt and quit when the user types 'quit'.
 * 
 * @author Douglas Hong
 * @version 3/4/2019 
 */

public class TextExcel{
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to TextExcel! Enter a command:(Type 'quit' to quit)");
        String expression = userInput.nextLine();
        Spreadsheet sheet = new Spreadsheet();
        while(!expression.equalsIgnoreCase("quit")) {
        	System.out.println(sheet.processCommand(expression));
        	System.out.println("Enter a command:(Type 'quit' to quit)");
          	expression = userInput.nextLine();
        }
        System.out.println("Spreadsheet stopped");
	}
}