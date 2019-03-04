package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * @author Douglas Hong
 * @version 3/4/2019
 */
// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
        System.out.println("Input:(Type 'quit' to quit)");
        String expression = userInput.nextLine();
        while(!expression.equalsIgnoreCase("quit")) {
        	Spreadsheet sheet = new Spreadsheet();
        	System.out.println(sheet.processCommand(expression));
        	System.out.println("Input:(Type 'quit' to quit)");
        	expression = userInput.nextLine();
        }
        System.out.println("Spreadsheet stopped");
	}
}
