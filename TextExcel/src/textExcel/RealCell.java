package textExcel;
/* RealCell is the superclass of PercentCell, FormulaCell, and ValueCell. 
 * This makes sure the subclasses have these methods: fullCellText, abbreviatedCellText, getDoubleValue
 * 
 * @author Douglas Hong
 * @version 3/27/2019
 */	
public class RealCell implements Comparable, Cell {
	private String text;
	//the contructor only has to store a String, which is the user input
	public RealCell(String text) {
		this.text = text;
	}
	//returns the full text for cell inspection
	public String fullCellText() {
		return text; 
	}
	//makes sure the value on the grid has a length of 10
	public String abbreviatedCellText() {
		String abbrev = getDoubleValue() + "          ";
		return abbrev.substring(0,10);
	}
	//parses the String to get a double
	public double getDoubleValue() {
		return Double.parseDouble(text);
	}
	public int compareTo(Object obj) {
		if(obj instanceof RealCell) {
			RealCell real = (RealCell)obj;
			if(getDoubleValue() < real.getDoubleValue()) {
				return -1;
			}else if (getDoubleValue() > real.getDoubleValue()) {
				return 1;
			}else {
				return 0;
			}
		}
		return -1;
	}
}
