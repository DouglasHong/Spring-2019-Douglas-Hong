package textExcel;
/* FormulaCell is a subclass of RealCell. It handles the command when the user puts in a formula. 
 * 
 * @author Douglas Hong
 * @version 3/27/2019
 */
public class FormulaCell extends RealCell {
	private String text;
	//calls the super's constructor and fills in the text field
	public FormulaCell(String text) {
		super(text);
		this.text = text;
	}
	//calls the super's fullCellText to get number value in cell inspection
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
		double answer = Double.parseDouble(splitText[0]);
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
		return answer;
	}
}
