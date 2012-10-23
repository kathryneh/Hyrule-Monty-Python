package scanner;

public class Token implements Tokenizable{

	String stringValue;
	String description;
	String input;

	public String getStringValue() {
		return stringValue;
	}

	public String getDescription() {
		return description;
	}

	public void setStringValue(String input) {
		stringValue = input;
		setDescription();
		returnToken();

	}

	public void setDescription() {
		description = "command";

	}

	public String returnToken() {
		//setDescription();
		return description + " " + stringValue;
	}
	
	public String toString(String input){
		return super.toString();
	}
}


