package scanner;

public class TokenList implements Listable {
	int size = 0;
	Token[] tokenCollection = new Token[MAX_SIZE];
	
	public int size() {
		return size;
	}

	public boolean isFull() {
		return size == MAX_SIZE;
	}

	public void addToken(Token token) {
		 if (isFull())
	            System.out.println("Adding item to a full history");
	        else {
	            tokenCollection[size] = token;
	            size++;
	        }
	}

	public Token tokenAt(int index) {
		return tokenCollection[index];
	}

}
