package scanner;

public class NumberToken extends Token implements Tokenizable {
	int stringValue;
	@Override
	//this overriden method changes the string input value to an integer
	public void setStringValue(String input){
		stringValue = Integer.parseInt(input);
		setDescription();
		returnToken();
	}
	@Override
	public void setDescription() {
		description = "number";

	}
	@Override
	public String returnToken(){
		return description + " " + stringValue;
	}
}
