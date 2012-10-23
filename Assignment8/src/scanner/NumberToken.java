package scanner;

public class NumberToken extends Token implements Tokenizable {
	public NumberToken(String input) {
		super("Number", input);
	}
	int stringValue;
	@Override
	//this overriden method changes the string input value to an integer
	public void setStringValue(String input){
		stringValue = Integer.parseInt(input);
	}
}
