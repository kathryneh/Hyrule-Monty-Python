package scanner;

public class TokenHistory implements Historical {
	protected int size = 0;
	protected Token[] tokenCollection = new Token[MAX_SIZE];

	public int size() {
		return size;
	}

	public boolean isFull() {
		return size == MAX_SIZE;
	}

	public void addToken(Token finalArray) {
		if (isFull())
			System.out.println("Adding item to a full history");
		else {
			tokenCollection[size] = finalArray;
			size++;
		}
	}

	public Token tokenAt(int index) {
		return tokenCollection[index];
	}

}
