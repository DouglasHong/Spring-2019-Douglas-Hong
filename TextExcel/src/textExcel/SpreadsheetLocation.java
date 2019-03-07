/*
 * @author Douglas Hong
 * @version 3/6/2019
 */
package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{
	private int row;
	private int col;
	public SpreadsheetLocation(String cellName) {
		cellName = cellName.toUpperCase();
		col = (int)cellName.charAt(0) - 65;
		row = Integer.parseInt(cellName.substring(1, cellName.length())) - 1;
	}
    @Override
    public int getRow(){ // gets row of this location
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol() // gets column of this location
    {
        // TODO Auto-generated method stub
        return col;
    }

}
