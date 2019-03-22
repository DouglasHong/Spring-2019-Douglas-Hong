package textExcel;

public class PercentCell extends RealCell { 
	private String text;
	private double value;
	public PercentCell(String text) {
		super(text);
	}
	public String fullCellText() {
		return text;
	}
	public String abbreviatedCellText() {
		//String abbrev = text.charAt(1) + "%";
		return super.abbreviatedCellText();
	}
	public double getDoubleValue() {
		value = Double.parseDouble(text.substring(0, text.length() - 1));
		return value/100;
	}
}
