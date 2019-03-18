/*
 * @author Douglas Hong
 * @version 3/6/2019
 */
package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	private int numRow;
	private int numCol;
	private Cell[][] sheet;
	
	public Spreadsheet() {
		//make 2D array with all elements containing EmptyCellObjects
		numRow = 20;
		numCol = 12;
		sheet = new Cell[numRow][numCol];
		for(int row = 0; row < numRow; row++) {
			for(int col = 0; col < numCol; col++) {
				sheet[row][col] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command){
		if(command.length() == 2 || command.length() == 3) {
			System.out.println(cellInspection(command));
		}else if(command.substring(0, 5).equalsIgnoreCase("clear")){
			System.out.println(clear(command));
		}else {
			System.out.println(assignCell(command));
		}
		return "";
	}
	public String cellInspection(String input) {
		SpreadsheetLocation loc = new SpreadsheetLocation(input);
		return getCell(loc).fullCellText();
	}
	public String clear(String input) {
		if(input.equalsIgnoreCase("clear")) {
			for(int row = 0; row < numRow; row++) {
				for(int col = 0; col < numCol; col++) {
					sheet[row][col] = new EmptyCell();
				}
			}
			return getGridText();
		}else {
			String[] splitInput = input.split(" ");
			SpreadsheetLocation loc = new SpreadsheetLocation(splitInput[1]);
			sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			return getGridText();
		}
	}
	public String assignCell(String input) {
		String[] splitInput = new String[2];
		splitInput = input.split(" = ");
		SpreadsheetLocation loc = new SpreadsheetLocation(splitInput[0]);
		TextCell newCell = new TextCell(splitInput[1]);
		sheet[loc.getRow()][loc.getCol()] = newCell;
		return getGridText();
	}
	//
	public int getRows(){
		return numRow;
	}
	//
	public int getCols(){
		return numCol;
	}
	//
	public Cell getCell(Location loc){
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String grid = "   |";
		char columnChar = 'A';
		for(int i = 0; i < numCol; i++) {
			grid += (columnChar + "         |");
			columnChar++;
		}
		for(int j = 0; j < numRow; j++) {
			if((j+1) < 10) {
				grid += ("\n" + (j+1) + "  |");
			}else{ // one less space if the number is 10 or greater
				grid += ("\n" + (j+1) + " |");
			}
			for(int k = 0; k < numCol; k++) {
				grid += sheet[j][k].abbreviatedCellText();
				for(int l = sheet[j][k].abbreviatedCellText().length(); l < 10; l++){
					grid += " ";
				}
				grid += "|";
			}
		}
		return grid;
	}
}
