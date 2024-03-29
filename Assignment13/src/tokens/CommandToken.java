package tokens;


public class CommandToken extends Token implements Tokenizable {
	
	public CommandToken(String newInput){
		super(newInput);
		setDescription("Command");
	}
	
	@Override
	//this ensures that for command tokens, the input is lowercase
	public void setStringValue(String token) {
		this.input = token;
		String editedInput = token.toLowerCase();
		stringValue = editedInput;
		getToken();
	}
	
	public void setInputToken(String token){
		this.input = token;
	}
	
	@Override 
	public String toString(){
		return this.input;
	}
}
