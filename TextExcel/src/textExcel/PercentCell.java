package textExcel;

public class PercentCell extends RealCell { 
	private String text;
	public PercentCell(String text) {
		super(text);
	}
	public String fullCellText() {
		return super.fullCellText();
	}
	public String abbreviatedCellText() {
		String[] truncated = super.abbreviatedCellText().split(".", 2);
		return truncated[0] + "%";
	}
	public double getDoubleValue() {
		return Double.parseDouble(text.substring(0, text.length() - 1))/100;
	}
}
