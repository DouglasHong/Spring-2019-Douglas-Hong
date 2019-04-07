package textExcel;
/* FormulaCell is a subclass of RealCell. It handles the command when the user puts in a formula. 
 * 
 * @author Douglas Hong
 * @version 3/27/2019
 */
public class FormulaCell extends RealCell {
	private Cell[][] cells;
	//calls the super's constructor and fills in the text and cells field
	public FormulaCell(String text, Cell[][] cells) {
		super(text);
		this.cells = cells;
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
		String textWithoutParentheses = super.fullCellText().substring(2, super.fullCellText().length()-1);
		String[] splitText = textWithoutParentheses.split(" ");
		double answer = 0;
		int numCount = 0; //counter for the number of times a number has been added/changed
		if(splitText[0].equalsIgnoreCase("SUM") || splitText[0].equalsIgnoreCase("AVG")) { //handles sum and avg formulas
			String[] splitCell = splitText[1].split("-");
			int startRow = Integer.parseInt(splitCell[0].substring(1, splitCell[0].length()));
			char startCol = splitCell[0].toUpperCase().charAt(0);
			int endRow = Integer.parseInt(splitCell[1].substring(1, splitCell[0].length()));
			char endCol = splitCell[1].toUpperCase().charAt(0);
			for(char i = startCol; i <= endCol; i++) {
				for(int j = startRow; j <= endRow; j++) {
					SpreadsheetLocation loc = new SpreadsheetLocation(i + "" + j);
					RealCell real = (RealCell)cells[loc.getRow()][loc.getCol()];
					answer += real.getDoubleValue();
					numCount++;
				}
			}
			if(splitText[0].equalsIgnoreCase("AVG")) {
				answer /= numCount;
			}
		}else { //handles formula without keywords
			//converts each cell identifier into a double value
			for(int i = 0; i < splitText.length; i++) {
				if(splitText[i].charAt(0) >= 'A' && splitText[i].charAt(0) <= 'l') {
					SpreadsheetLocation loc = new SpreadsheetLocation(splitText[i]);
					RealCell real = (RealCell)cells[loc.getRow()][loc.getCol()];
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
}