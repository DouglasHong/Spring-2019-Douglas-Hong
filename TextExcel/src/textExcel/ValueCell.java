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
}
