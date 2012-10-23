package scanner;

public class StringToken extends Token implements Tokenizable {
	public StringToken(String input) {
		super("Quoted String", input);
	}
}
