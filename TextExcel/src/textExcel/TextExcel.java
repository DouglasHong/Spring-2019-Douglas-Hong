package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * @author Douglas Hong
 * @version 3/4/2019
 */
// Update this file with your own code.

public class TextExcel{
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a command:(Type 'quit' to quit)");
        String expression = userInput.nextLine();
        Spreadsheet sheet = new Spreadsheet();
        while(!expression.equalsIgnoreCase("quit")) {
        	System.out.println(sheet.processCommand(expression));
        	SpreadsheetLocation loc = new SpreadsheetLocation(expression);
        	System.out.println(loc.getRow());
        	System.out.println(loc.getCol());
        	System.out.println("Enter a command:(Type 'quit' to quit)");
        	expression = userInput.nextLine();
        }
        System.out.println("Spreadsheet stopped");
	}
}
