package textExcel;

public class RealCell implements Cell {
	private String text;
	private double value;
	public RealCell(String text) {
		this.text = text;
	}
	public String fullCellText() {
		//if they put 12, truncate .0 from double
		return getDoubleValue() + "";
	}
	public String abbreviatedCellText() {
		String abbrev = text + "          ";
		return abbrev.substring(0,10);
	}
	public double getDoubleValue() {
		value = Double.parseDouble(text);
		return value;
	}
}
