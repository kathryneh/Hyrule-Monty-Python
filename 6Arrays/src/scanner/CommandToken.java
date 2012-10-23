package scanner;

public class CommandToken implements Token {
	String stringValue;
	String description;

	@Override
	public String getStringValue() {
		return stringValue;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setStringValue(String input) {
		String editedInput = input.toLowerCase();
		stringValue = editedInput;
		returnToken();

	}

	@Override
	public void setDescription() {
		description = "command";
		// returnToken();

	}

	@Override
	public String returnToken() {
		setDescription();
		return description + " " + stringValue;
	}
}
