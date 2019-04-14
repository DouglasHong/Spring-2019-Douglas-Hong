package textExcel;

import java.util.*;

/* Spreadsheet handles the user input and prints a full grid.
 * 
 * @author Douglas Hong
 * @version 3/6/2019
 */
public class Spreadsheet implements Grid{
	private int numRow;
	private int numCol;
	private Cell[][] sheet;
	
	//makes a 2D array with all elements containing EmptyCells
	public Spreadsheet() { 
		numRow = 20;
		numCol = 12;
		sheet = new Cell[numRow][numCol];
		clearGrid();
	}
	//processes the user input and stores values in the correct cells
	public String processCommand(String command){
		SpreadsheetLocation loc;
		if(command.equals("")) { //satisfies checkpoint 1
			return "";
		}else if(command.length() <= 3) {
			loc = new SpreadsheetLocation(command);
			return getCell(loc).fullCellText();
		}else if(command.substring(0, 5).equalsIgnoreCase("clear")){
			if(command.equalsIgnoreCase("clear")) {
				clearGrid();
			}else {
				String[] splitInput = command.split(" ", 2);
				loc = new SpreadsheetLocation(splitInput[1]);
				sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			}
			return getGridText();
		}else if(command.substring(0, 4).equalsIgnoreCase("sort")){
			sort(command);
			return getGridText();
		}else{
			assignCell(command); 
			return getGridText();
		}	
	}
	//clears the entire grid by filling in each cell with an EmptyCell
	public void clearGrid() {
		for(int row = 0; row < numRow; row++) {
			for(int col = 0; col < numCol; col++){
				sheet[row][col] = new EmptyCell();
			}
		}
	}
	//assigns values to a PercentCell, FormulaCell, ValueCell, or TextCell
	public void assignCell(String input) {
		String[] splitInput = new String[2];
		splitInput = input.split(" = ", 2);
		SpreadsheetLocation loc = new SpreadsheetLocation(splitInput[0]);
		if(splitInput[1].endsWith("%")){
			sheet[loc.getRow()][loc.getCol()] = new PercentCell(splitInput[1]);
		}else if(splitInput[1].startsWith("(")) {
			sheet[loc.getRow()][loc.getCol()] = new FormulaCell(splitInput[1], sheet);
		}else if(splitInput[1].contains("\"")){
			sheet[loc.getRow()][loc.getCol()] = new TextCell(splitInput[1]);
		}else {
			sheet[loc.getRow()][loc.getCol()] = new ValueCell(splitInput[1]);
		}
	}
	//gets the total number of rows
	public int getRows(){
		return numRow;
	}
	//gets the total number of columns
	public int getCols(){
		return numCol;
	}
	//gets the location of the cell passed in
	public Cell getCell(Location loc){
		return sheet[loc.getRow()][loc.getCol()];
	}
	//prints the whole grid, along with the cells in it
	public String getGridText(){
		String grid = "   |";
		//creates a letter for each column
		for(char columnChar = 'A'; columnChar <= 'L'; columnChar++) {
			grid += (columnChar + "         |");
		}
		//creates the row number
		for(int row = 0; row < numRow; row++) {
			if((row+1) < 10) {
				grid += "\n" + (row+1) + "  |";
			}else{ // one less space if the number is 10 or greater
				grid += "\n" + (row+1) + " |";
			}
			//adds the cell text and makes sure it's 10 spaces
			for(int col = 0; col < numCol; col++) {
				grid += sheet[row][col].abbreviatedCellText();
				for(int l = sheet[row][col].abbreviatedCellText().length(); l < 10; l++){
					grid += " ";
				}
				grid += "|";
			}
		}
		return grid + "\n";
	}
	//this method handles ascending and descending sorting 
	public void sort(String command) {
		String[] splitCommand = command.split(" ");
		String[] cellRegion = splitCommand[1].split("-");
		int startRow = Integer.parseInt(cellRegion[0].substring(1, cellRegion[0].length()));
		char startCol = cellRegion[0].toUpperCase().charAt(0);
		int endRow = Integer.parseInt(cellRegion[1].substring(1, cellRegion[1].length()));
		char endCol = cellRegion[1].toUpperCase().charAt(0);
		ArrayList<Cell> sortCells = new ArrayList<Cell>();
		//fills in the arraylist with each cell in the region
		for(int i = startRow; i <= endRow; i++) {
			for(char j = startCol; j <= endCol; j++) {
				SpreadsheetLocation loc = new SpreadsheetLocation(j + "" + i);
				sortCells.add(getCell(loc));
			}
		}
		//the arraylist is sorted by using the compareTo methods
		for(int i = 0; i < sortCells.size(); i++) {
			for(int j = 0; j < sortCells.size()-1; j++) {
				if(sortCells.get(i) instanceof TextCell) {
					TextCell firstCell = (TextCell)sortCells.get(j);
					TextCell secondCell = (TextCell)sortCells.get(j+1);
					TextCell temp;
					if((firstCell.compareTo(secondCell) > 0 && command.substring(0, 5).equalsIgnoreCase("sorta")) || (firstCell.compareTo(secondCell) < 0 && command.substring(0, 5).equalsIgnoreCase("sortd"))) {
						temp = firstCell;
						sortCells.set(j, secondCell);
						sortCells.set(j+1, temp);
					}
				}else if(sortCells.get(i) instanceof RealCell){
					RealCell firstCell = (RealCell)sortCells.get(j);
					RealCell secondCell = (RealCell)sortCells.get(j+1);
					RealCell temp;
					if(((firstCell.compareTo(secondCell) > 0 && command.substring(0, 5).equalsIgnoreCase("sorta")) || (firstCell.compareTo(secondCell) < 0 && command.substring(0, 5).equalsIgnoreCase("sortd")))) {
						temp = firstCell;
						sortCells.set(j, secondCell);
						sortCells.set(j+1, temp);
					}
				}
			}
		}
		//once the arraylist has been sorted, the sheet can updated with the cells in the correct order
		int index = 0;
		for(int i = startRow; i <= endRow; i++) {
			for(char j = startCol; j <= endCol; j++) {
				SpreadsheetLocation loc = new SpreadsheetLocation(j + "" + i);
				sheet[loc.getRow()][loc.getCol()] = sortCells.get(index);
				index++;
			}
		}
	}
}