package scanner;

import tokens.Token;

public interface Historical {
	public final int MAX_SIZE = 50;
	public int size();
	public Token elementAt(int index);
	boolean isFull();
	public void push(Token token);
}
