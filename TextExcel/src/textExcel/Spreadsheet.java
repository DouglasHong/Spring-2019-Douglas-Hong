/*
 * @author Douglas Hong
 * @version 3/6/2019
 */
package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	private int row;
	private int col;
	
	public Spreadsheet() {
		//make 2D array with all elements containing EmptyCellObjects
		 EmptyCell[][] empty = new EmptyCell[row][col];
	}
	@Override
	public String processCommand(String command){
		return "";
	}
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc){
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
