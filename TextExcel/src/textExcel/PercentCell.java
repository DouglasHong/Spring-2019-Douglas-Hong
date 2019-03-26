package textExcel;

public class PercentCell extends RealCell { 
	private String text;
	public PercentCell(String text) {
		super(text);
		this.text = text;
	}
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	public String abbreviatedCellText() {
		return (int)(getDoubleValue()*100) + "%";
	}
	public double getDoubleValue() {
		return Double.parseDouble(text.substring(0, text.length()-1))/100;
	}
}
