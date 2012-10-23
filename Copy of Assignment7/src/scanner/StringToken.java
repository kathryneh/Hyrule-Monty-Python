package scanner;

public class StringToken extends Token implements Tokenizable {
	@Override
	public void setDescription() {
		description = "quoted string";
		returnToken();

	}
	@Override
	public String returnToken(){
		return description + " " + stringValue;
	}
}
