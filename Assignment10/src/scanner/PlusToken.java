package scanner;

public class PlusToken extends Token implements Tokenizable {

	public PlusToken(char curChar) {
		super(curChar);
		setDescription("Plus");
	}
}
