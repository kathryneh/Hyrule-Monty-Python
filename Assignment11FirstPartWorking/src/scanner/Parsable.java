package scanner;

public interface Parsable extends Scannable {
	public String getInput();
	public void setReturnedString(String tokenString);
	public String getReturnedString();
	public void takeUserInput(String arg);
	public TokenHistory getTokenList();
	public void tokenParser(TokenHistory listable);
}
