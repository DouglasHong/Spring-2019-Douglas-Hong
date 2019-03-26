package textExcel;

public class ValueCell extends RealCell{
	private String text;
	public ValueCell(String text) {
		super(text);
		this.text = text;
	}
	public String fullCellText() {
		return super.fullCellText();
	}
	public String abbreviatedCellText() {
		String value = getDoubleValue() + "          ";
		return value.substring(0, 10);
	}
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}
