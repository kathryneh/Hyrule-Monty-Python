package scanner;

public abstract class Token implements Tokenizable{

	protected String stringValue;
	protected String description;
	protected String input;
	protected char charInput;

	public Token(String input){
		setStringValue(input);
	}
	public Token(char input){
		setStringValue(input);
	}
	public String getStringValue() {
		return stringValue;
	}
	public char getCharValue(){
		return charInput;
	}

	public String getDescription() {
		return description;
	}

	public void setStringValue(String input) {
		stringValue = input;
	}
	public void setStringValue(char input){
		charInput = input;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public String getToken() {
		//setDescription();
		return getDescription() + " " + getStringValue();
	}
	
	public String toString(String input){
		return super.toString();
	}

}


