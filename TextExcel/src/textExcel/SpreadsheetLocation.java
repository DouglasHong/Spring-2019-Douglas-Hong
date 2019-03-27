package textExcel;
 
/* SpreadsheetLocation gives the location of the cell passed as [row][col]
 * 
 * @author Douglas Hong
 * @version 3/6/2019
 */

public class SpreadsheetLocation implements Location{
	private int row;
	private int col;
	//this is the constructor, which puts in the value of col and row
	public SpreadsheetLocation(String cellName) {
		cellName = cellName.toUpperCase();
		col = cellName.charAt(0) - 'A';
		row = Integer.parseInt(cellName.substring(1, cellName.length())) - 1;
	}
	// gets row of this location
    public int getRow(){ 
        return row;
    }
    // gets column of this location
    public int getCol() {
        return col;
    }
}
