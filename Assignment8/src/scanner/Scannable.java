package scanner;

public interface Scannable {
	public void findTokens();

	public void findNumber();

	public void findCommand();

	public void findQuotedString();
	
	public void setTokenString(String arg);
	
	@Override
	public String toString();

}
