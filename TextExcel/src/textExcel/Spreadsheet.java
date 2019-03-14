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
		SpreadsheetLocation loc = new SpreadsheetLocation(command);
		if(command.length() == 2 || command.length() == 3) {
			return sheet[loc.getRow()][loc.getCol()].fullCellText();
		}else if(command.contains("clear")){
			if(command.equalsIgnoreCase("clear")) {
				sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			}else {
				return getGridText();
			}
		}else {
			String[] splitCommand = command.split("=");
			loc = new SpreadsheetLocation(splitCommand[0]);
			sheet[loc.getRow()][loc.getCol()] = splitCommand[1];
		}
		return "";
	}
	
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return numRow;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return numCol;
	}

	@Override
	public Cell getCell(Location loc){
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String grid = "   |";
		char columnChar = 'A';
		int rowCount = 1;
		for(int i = 0; i < numCol; i++) {
			grid += (columnChar + "         |");
			columnChar++;
		}
		for(int j = 0; j < numRow; j++) {
			if(rowCount < 10) {
				grid += ("\n" + rowCount + "  |");
			}else{ // one less space if the number is 10 or greater
				grid += ("\n" + rowCount + " |");
			}
			rowCount++;
			for(int k = 0; k < numCol; k++) {
				grid += ("          |");
			}
		}
		return grid;
	}

}
