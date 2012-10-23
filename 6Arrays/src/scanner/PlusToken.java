package scanner;

public class PlusToken implements Token {
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
		stringValue = input;
		returnToken();

	}

	@Override
	public void setDescription() {
		description = "plus";
		returnToken();

	}

	@Override

	public String returnToken() {
		return description + " " + stringValue;
	}

}
