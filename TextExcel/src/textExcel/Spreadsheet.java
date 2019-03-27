package textExcel;

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
		for(int row = 0; row < numRow; row++) {
			for(int col = 0; col < numCol; col++) {
				sheet[row][col] = new EmptyCell();
			}
		}
	}
	//processes the user input and stores values in the correct cells
	public String processCommand(String command){
		SpreadsheetLocation loc;
		if(command.length() <= 3) {
			loc = new SpreadsheetLocation(command);
			return getCell(loc).fullCellText();
		}else if(command.substring(0, 5).equalsIgnoreCase("clear")){
			clear(command);
			return getGridText();
		}else{
			assignCell(command); // assigns percent, value, formula, and text cells
			return getGridText();
		}	
	}
	//clears the whole grid, or clears only one cell
	public void clear(String input) {
		if(input.equalsIgnoreCase("clear")) {
			for(int row = 0; row < numRow; row++) {
				for(int col = 0; col < numCol; col++) {
					sheet[row][col] = new EmptyCell();
				}
			}
		}else {
			String[] splitInput = input.split(" ", 2);
			SpreadsheetLocation loc = new SpreadsheetLocation(splitInput[1]);
			sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
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
			sheet[loc.getRow()][loc.getCol()] = new FormulaCell(splitInput[1]);
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
		return grid + "\n";
	}
	
}
