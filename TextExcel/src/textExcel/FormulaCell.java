package textExcel;
/* FormulaCell is a subclass of RealCell. It handles the command when the user puts in a formula. 
 * 
 * @author Douglas Hong
 * @version 3/27/2019
 */
public class FormulaCell extends RealCell {
	private String text;
	private Cell[][] sheet;
	//calls the super's constructor and fills in the text field
	public FormulaCell(String text) {
		super(text);
		this.text = text;
	}
	//calls the super's fullCellText for cell inspection
	public String fullCellText() {
		return super.fullCellText();
	}
	//calls the super's abbreviatedCellText to fit the grid
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	//splits the formula to do multiple operations with it and return a double value
	public double getDoubleValue() {
		String textWithoutParentheses = text.substring(2, text.length()-1);
		String[] splitText = textWithoutParentheses.split(" ");
		double answer = 0;
		int numCount = 0;
		if(splitText[0].equalsIgnoreCase("SUM") || splitText[0].equalsIgnoreCase("AVG")) {
			String[] splitCell = splitText[1].split("-");
			int startRow = Integer.parseInt(splitCell[0].substring(1, splitCell[0].length()));
			char startCol = splitCell[0].charAt(0);
			int endRow = Integer.parseInt(splitCell[1].substring(1, splitCell[0].length()));
			char endCol = splitCell[1].charAt(0);
			for(char i = startCol; i <= endCol; i++) {
				for(int j = startRow; j <= endRow; j++) {
					SpreadsheetLocation loc = new SpreadsheetLocation(i + "" + j);
					RealCell real = (RealCell)sheet[loc.getRow()][loc.getCol()];
					answer += real.getDoubleValue();
					numCount++;
				}
			}
			if(splitText[0].equalsIgnoreCase("AVG")) {
				answer /= numCount;
			}
		}else {
			for(int i = 0; i < splitText.length; i++) {
				if(splitText[i].charAt(0) >= 'A' && splitText[i].charAt(0) <= 'L') {
					SpreadsheetLocation loc = new SpreadsheetLocation(splitText[i]);
					RealCell real = (RealCell)sheet[loc.getRow()][loc.getCol()];
					splitText[i] = real.getDoubleValue() + "";
				}
			}
			answer = Double.parseDouble(splitText[0]);
			for(int i = 0; i < splitText.length; i++) {
				if(splitText[i].equals("+")){
					answer += Double.parseDouble(splitText[i+1]);
				}else if(splitText[i].equals("-")) {
					answer -= Double.parseDouble(splitText[i+1]);
				}else if(splitText[i].equals("*")) {
					answer *= Double.parseDouble(splitText[i+1]);
				}else if(splitText[i].equals("/")){
					answer /= Double.parseDouble(splitText[i+1]);
				}
			}
		}
		return answer;
	}
	public void setSheet(Cell[][] sheet) {
		this.sheet = sheet;
	}
}
