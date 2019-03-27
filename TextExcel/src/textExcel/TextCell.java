package textExcel;

/* TextCell implements the Cell interface and stores a String
 * 
 * @author Douglas Hong
 * @version 3/27/2019
 */
public class TextCell implements Cell{ 
	private String text;
	//the constructor stores a String/user input
	public TextCell(String text) {
		if(text.startsWith("\"")) { //for strings
			this.text = text.substring(1, text.length()-1);
		}else { //for numbers
			this.text = text;
		}
	}
	//prints the full String with quotes around it
	public String fullCellText() {
		return "\"" + text + "\"";
	}
	//abbreviates the String so it fits in the grid
	public String abbreviatedCellText() {
		String abbrev = text + "          ";
		return abbrev.substring(0,10);
	}
}
