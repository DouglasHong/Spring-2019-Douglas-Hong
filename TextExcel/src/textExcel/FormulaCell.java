package textExcel;

public class FormulaCell extends RealCell {
	private String text;
	private double value;
	public FormulaCell(String text) {
		super(text);
	}
	public String fullCellText() {
		return super.fullCellText();
	}
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	public double getDoubleValue() {
		return value;
	}
}
