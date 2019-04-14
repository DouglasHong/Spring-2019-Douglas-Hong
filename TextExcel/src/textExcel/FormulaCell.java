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
	//splits the formula to do multiple operations with it and return a double value
	public double getDoubleValue() {
		String textWithoutParentheses = super.fullCellText().substring(2, super.fullCellText().length()-1);
		String[] splitFormula = textWithoutParentheses.split(" ");
		double answer = 0;
		int numCount = 0; //counter for the number of times a number has been added/changed
		if(splitFormula[0].equalsIgnoreCase("SUM") || splitFormula[0].equalsIgnoreCase("AVG")) { //handles sum and avg formulas
			String[] splitCell = splitFormula[1].split("-");
			int startRow = Integer.parseInt(splitCell[0].substring(1, splitCell[0].length()));
			char startCol = splitCell[0].toUpperCase().charAt(0);
			int endRow = Integer.parseInt(splitCell[1].substring(1, splitCell[0].length()));
			char endCol = splitCell[1].toUpperCase().charAt(0);
			for(int i = startRow; i <= endRow; i++) {
				for(char j = startCol; j <= endCol; j++) {
					SpreadsheetLocation loc = new SpreadsheetLocation(j + "" + i);
					RealCell real = (RealCell)cells[loc.getRow()][loc.getCol()];
					answer += real.getDoubleValue();
					numCount++;
				}
			}
			if(splitFormula[0].equalsIgnoreCase("AVG")) {
				answer /= numCount;
			}
		}else { //handles formula without keywords
			//converts each cell identifier into a double value
			for(int i = 0; i < splitFormula.length; i++) {
				if(splitFormula[i].charAt(0) >= 'A' && splitFormula[i].charAt(0) <= 'l') {
					SpreadsheetLocation loc = new SpreadsheetLocation(splitFormula[i]);
					RealCell real = (RealCell)cells[loc.getRow()][loc.getCol()];
					splitFormula[i] = real.getDoubleValue() + "";
				}
			}
			answer = Double.parseDouble(splitFormula[0]);
			for(int i = 0; i < splitFormula.length; i++) {
				if(splitFormula[i].equals("+")){
					answer += Double.parseDouble(splitFormula[i+1]);
				}else if(splitFormula[i].equals("-")) {
					answer -= Double.parseDouble(splitFormula[i+1]);
				}else if(splitFormula[i].equals("*")) {
					answer *= Double.parseDouble(splitFormula[i+1]);
				}else if(splitFormula[i].equals("/")){
					answer /= Double.parseDouble(splitFormula[i+1]);
				}
			}
		}
		return answer;
	}
}