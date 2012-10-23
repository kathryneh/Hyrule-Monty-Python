package scanner;

public interface Scannable {
	public void findTokens(String input);

	public void findNumber();

	public void findCommand();

	public void findQuotedString();
	
	public void setInput(String arg);
	
	@Override
	public String toString();

	void findPlus();

	void findMinus();

}
