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
		String abbrev = (int)(getDoubleValue()*100) + "";
		if(abbrev.length() > 10) {
			abbrev = abbrev.substring(0, 10) + "%";
		}else {
			abbrev += "%          ";
			abbrev = abbrev.substring(0, 10);
		}
		return abbrev;
	}
	public double getDoubleValue() {
		return Double.parseDouble(text.substring(0, text.length()-1))/100;
	}
}
