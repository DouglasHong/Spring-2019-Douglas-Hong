package fracCalc;

public class Fraction {
	private int wholeNum;
	private int numerator;
	private int denominator;
	public Fraction(String operator) {
		
	}
	public Fraction() {
		wholeNum = 0;
		numerator = 0;
		denominator = 0;
	}
	public void toImproperFrac(Fraction frac) {
    	if(frac.getWholeNum() >= 0) {
    		frac.setNumerator(frac.getWholeNum()*frac.getDenominator()+frac.getNumerator());
    	}else {
    		frac.setNumerator(frac.getWholeNum()*frac.getDenominator()-frac.getNumerator());
    	}
    	frac.setWholeNum(0);
    }
	public String doMath(String operator, Fraction operand) {
		if(operator.equals("+")) {
			
		}else if(operator.equals("-")) {
			
		}else if(operator.equals("*")) {
			
		}else {
			
		}
	}
	public String toString() {
		return wholeNum + "_" + numerator + "/" + denominator;
	}
	public int getWholeNum() {
		return wholeNum;
	}
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setWholeNum(int wholeNum) {
		this.wholeNum = wholeNum;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
}
