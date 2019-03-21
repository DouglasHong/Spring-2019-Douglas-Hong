package textExcel;

public class RealCell implements Cell {
	private String text;
	private double value;
	public RealCell(String text) {
		this.text = text;
		value = Double.parseDouble(text);
	}
	public String fullCellText() {
		//if they put 12, truncate .0 from double
		return getDoubleValue() + "";
	}
	public String abbreviatedCellText() {
		String truncated = text + "          ";
		return truncated.substring(0,10);
	}
	public double getDoubleValue() {
		return value;
	}
}
