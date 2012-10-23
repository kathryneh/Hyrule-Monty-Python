package scanner;

import composition.TalkingScene;

public class StatefulObject implements Object{
	private String input;
	private String returnedString;
	private Parser ts;
	//private String arg;

	public StatefulObject(String arg) {
		setInput(arg);
		TalkingScene scene  = new TalkingScene();
		ts = new scanner.Parser(arg, scene);
		returnedString = ts.toString();
	}

	public String getInput() {
		return input;
	}

	public void setReturnedString(String tokenString) {
		// returnedString = returnedString + tokenString;
		//TokenScanner ts = new scanner.InheritedTokenScanner(input);
		returnedString = ts.toString();
	}

	public void setInput(String newInput) {
		input = newInput;
	}

	public String getReturnedString() {
		return returnedString;
	}
}
