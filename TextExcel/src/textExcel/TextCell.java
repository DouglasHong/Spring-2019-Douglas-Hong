package textExcel;

public class TextCell implements Cell{ 
	private String text;
	public TextCell(String text) {
		this.text = text.substring(1, text.length()-1);
	}
	public String fullCellText() {
		return "\"" + text + "\"";
	}
	public String abbreviatedCellText() {
		String truncated = text + "          ";
		return truncated.substring(0,10);
	}
	
}
