package textExcel;

public class FormulaCell extends RealCell {
	private String text;
	public FormulaCell(String text) {
		super(text);
		this.text = text;
	}
	public String fullCellText() {
		return super.fullCellText();
	}
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	public double getDoubleValue() {
		return 0;
	}
}
