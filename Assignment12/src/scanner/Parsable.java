package scanner;

public interface Parsable{
	public String getInput();
	public void takeUserInput(String newInput);
	public void setInput(String newInput);
	public TokenHistory getTokenList();
	public void tokenParser(TokenHistory listable);
	public int parseMoveToken(java.lang.Object[] tokens, int i);
	public void executeMoveCommand(int move);
	public void setMoveValue(int move);
	public int getMoveValue();
	public int parseChangePauseToken(java.lang.Object[] tokens, int i);
	public int parseChangeStepToken(java.lang.Object[] tokens, int i);
	public int parseSayToken(java.lang.Object[] tokens, int i);
}
