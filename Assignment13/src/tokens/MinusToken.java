package tokens;


public class MinusToken extends Token implements Tokenizable{

	public MinusToken(char curChar) {
		super(curChar);
		setDescription("Minus");
	}
	public char returnToken(){
		return charInput;
	}
}
