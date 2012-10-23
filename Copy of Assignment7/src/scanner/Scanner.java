package scanner;

public interface Scanner {
	public void findTokens();

	//public void findPlus();

	//public void findMinus();

	public void findNumber();

	public void findCommand();

	public void findQuotedString();

}
