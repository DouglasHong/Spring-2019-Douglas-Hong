package textExcel;

public class PercentCell { //extends RealCell 
	private String text;
	private double value;
	public PercentCell(String text) {
		this.text = text;
		value = Double.parseDouble(text.substring(0, text.length()-1));
	}
	public String fullCellText() {
		return text;
	}
	public String abbreviatedCellText() {
		String truncated = text.charAt(0) + "%";
		return truncated;
	}
	public double getDoubleValue() {
		return value/100;
	}
}
