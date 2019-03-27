package textExcel;

/* PercentCell is a subclass of RealCell. It handles the command when the user puts in a percentage.
 * 
 * @author Douglas Hong
 * @version 3/27/2019
 */
public class PercentCell extends RealCell { 
	private String text;
	//calls the super constructor and stores a value in the text field
	public PercentCell(String text) {
		super(text);
		this.text = text;
	}
	//prints the double value as a String
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	//makes sure the decimal is truncated and only the whole number is printed
	public String abbreviatedCellText() {
		String abbrev = (int)(getDoubleValue()*100) + "";
		if(abbrev.length() > 10) {
			abbrev = abbrev.substring(0, 10) + "%";
		}else {
			abbrev += "%          ";
			abbrev = abbrev.substring(0, 10);
		}
		return abbrev;
	}
	//converts the percentage to decimal form
	public double getDoubleValue() {
		return Double.parseDouble(text.substring(0, text.length()-1))/100;
	}
}
