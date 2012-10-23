package scanner;

public class Token implements Tokenizable{

	String stringValue;
	String description;
	String input;

	public Token(String description, String input){
		setStringValue(input);
		setDescription(description);
	}
	public String getStringValue() {
		return stringValue;
	}

	public String getDescription() {
		return description;
	}

	public void setStringValue(String input) {
		stringValue = input;
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


