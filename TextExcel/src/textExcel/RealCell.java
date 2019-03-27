package textExcel;

public class RealCell implements Cell {
	private String text;
	public RealCell(String text) {
		this.text = text;
	}
	public String fullCellText() {
		return text; //return getDoubleValue() + ""; ??????
	}
	public String abbreviatedCellText() {
		String abbrev = text + "          ";
		return abbrev.substring(0,10);
	}
	public double getDoubleValue() {
		return Double.parseDouble(text);
	}
}
