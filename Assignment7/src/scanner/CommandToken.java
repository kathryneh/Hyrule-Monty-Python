package scanner;

public class CommandToken extends Token implements Tokenizable {
	
	public CommandToken(){
		super();
	}
	
	@Override
	//this ensures that for command tokens, the input is lowercase
	public void setStringValue(String token) {
		this.input = token;
		String editedInput = token.toLowerCase();
		stringValue = editedInput;
		returnToken();
	}
	
	public void setInputToken(String token){
		this.input = token;
	}
	
	@Override 
	public String toString(){
		return this.input;
	}
}
