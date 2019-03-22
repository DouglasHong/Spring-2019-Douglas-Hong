package textExcel;

public class TextCell implements Cell{ 
	private String text;
	public TextCell(String text) {
		if(text.startsWith("\"")) { //for strings
			this.text = text.substring(1, text.length()-1);
		}else { //for numbers
			this.text = text;
		}
	}
	public String fullCellText() {
		return "\"" + text + "\"";
	}
	public String abbreviatedCellText() {
		String abbrev = text + "          ";
		return abbrev.substring(0,10);
	}
}
