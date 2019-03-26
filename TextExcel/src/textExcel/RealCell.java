package textExcel;

public class RealCell implements Cell {
	private String text;
	public RealCell(String text) {
		this.text = text;
	}
	public String fullCellText() {
		//if they put 12, truncate .0 from double
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
