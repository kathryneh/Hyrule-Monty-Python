package scanner;

public interface Parsable extends Scannable {
	public String getInput();
	public void setReturnedString(String tokenString);
	public String getReturnedString();
}
