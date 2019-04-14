package textExcel;
/* EmptyCell implements the Cell interface and is the default cell for the grid
 * 
 * @author Douglas Hong
 * @version 3/4/2019
 */

public class EmptyCell implements Cell {
	public EmptyCell() {
		 
	}
	//when the user inspects, nothing will be printed
	public String fullCellText() {
		return "";
	}
	//when the cell is printed on the grid, the cell is 10 blank spaces
	public String abbreviatedCellText() {
		return "          ";
	}
}

