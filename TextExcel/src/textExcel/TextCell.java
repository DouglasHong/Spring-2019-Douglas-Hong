package textExcel;

public class TextCell implements Cell{
	private String text;
	public TextCell(String text) {
		this.text = text;
	}
	public String fullCellText() {
		return "\"" + text + "\"";
	}
	public String abbreviatedCellText() {
		String truncated = "";
		for(int i = 0; i < 10; i++) {
			truncated += text.charAt(i);
		}
		return truncated;
	}
	
}
