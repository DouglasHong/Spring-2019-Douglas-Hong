
/*
 * @author Douglas Hong
 * @version 3/4/2019
 */

package textExcel;

public class EmptyCell implements Cell {
	// text for spreadsheet cell display, must be exactly length 10
	// text for individual cell inspection, not truncated or padded
	
	public EmptyCell() {
		
	}
	public String fullCellText() {
		return "";
	}
	public String abbreviatedCellText() {
		return "";
	}
}

