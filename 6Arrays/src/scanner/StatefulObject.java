package scanner;

public class StatefulObject implements Object{
	String input;
	String returnedString;

	public StatefulObject(String args) {
		setInput(args);
		TokenScanner ts = new scanner.TokenScanner(input);
		returnedString = ts.toString();
	}

	public String getInput() {
		return input;
	}

	public void setReturnedString(String tokenString) {
		// returnedString = returnedString + tokenString;
		TokenScanner ts = new scanner.TokenScanner(input);
		returnedString = ts.toString();
	}

	public void setInput(String newInput) {
		input = newInput;
	}

	public String getReturnedString() {
		return returnedString;
	}
}
