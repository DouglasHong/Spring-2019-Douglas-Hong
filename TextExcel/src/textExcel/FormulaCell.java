package textExcel;

public class FormulaCell extends RealCell {
	private String text;
	private double value;
	public FormulaCell(String text) {
		super(text);
	}
	public String fullCellText() {
		return text;
	}
	public String abbreviatedCellText() {
		return text;
	}
	public double getDoubleValue() {
		return 0;
	}
}
