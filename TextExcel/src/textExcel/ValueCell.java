package textExcel;

/* ValueCell is a subclass of RealCell. It handles the command when the user enters a number/decimal value.
 * 
 * @author Douglas Hong
 * @version 3/27/2019
 */
public class ValueCell extends RealCell{
	//calls the super constructor and stores a value in the text field
	public ValueCell(String text) {
		super(text);
	}
	//calls RealCell's fullCellText for cell inspection
	public String fullCellText() {
		return super.fullCellText();
	}
	//calls RealCell's abbreviatedCellText for displaying in the grid
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	//calls RealCell's getDoubleValue to convert to a double
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}
