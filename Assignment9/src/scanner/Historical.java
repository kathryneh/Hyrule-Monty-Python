package scanner;

public interface Historical {
	public final int MAX_SIZE = 50;
	public int size();
	public Token tokenAt(int index);
	boolean isFull();
	public void addToken(Token token);
}
