package scanner;

import util.models.VectorListener;

public class TokenHistory extends generics.GenericCollection<Token> implements Historical {
	//protected int size = 0;
	protected Token[] objectArray = new Token[MAX_SIZE];

	public TokenHistory(){
		//objectArray = new Token[MAX_SIZE];
		
	}
	/*public int size() {
		return size;
	}

	public boolean isFull() {
		return size == MAX_SIZE;
	}
	

	public void push(Token finalArray) {
		if (isFull())
			System.out.println("Adding item to a full history");
		else {
			objectArray[size] = finalArray;
			size++;
		}
	}

	public Token elementAt(int index) {
		return (Token) objectArray[index];
	}
	*/
	public void setIndex(int x){
		size = 0;
	}
	@Override
	public void addVectorListener(VectorListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}
