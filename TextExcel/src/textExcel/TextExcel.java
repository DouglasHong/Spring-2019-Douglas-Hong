package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
        System.out.println("Input: ");
        String expression = userInput.nextLine();
        while(!expression.equalsIgnoreCase("quit")) {
        	System.out.println(processCommand());
        	System.out.println("Input: ");
        	expression = userInput.nextLine();
        }
        System.out.println("Spreadsheet stopped");
	}
}
