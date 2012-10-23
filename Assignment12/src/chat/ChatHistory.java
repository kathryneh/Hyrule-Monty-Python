package chat;

public abstract class ChatHistory extends generics.ObservableCollection<Label> implements History, generics.GenericCollectable<Label> {

	//protected int size = 0;
	//final static int ARRAY_MAX_SIZE = 50;
	//protected String[] StringArray = new String[ARRAY_MAX_SIZE];
	int[] xArray = new int[ARRAY_MAX_SIZE];
	int[] yArray = new int[ARRAY_MAX_SIZE];
	//protected int x;
	//protected int y;
	//final static int LABEL_ARRAY_SIZE = 10;
	//Object[] objectArray = new Object[ARRAY_MAX_SIZE];

	public ChatHistory(int x, int y) {
		setX(x);
		setY(y);
		/*push("A man said to the universe:");
		push("'Sir I exist!'");
		push("'However,' replied the universe, ");
		push("'The fact has not created in me ");
		push("A sense of obligation.'");
		*/
		//getObjectArray();
	}
/*
	public void push(int x, int y, String element) {
		if (size < ARRAY_MAX_SIZE) {
		//	objectArray[size] = new graphics.(x, y, element);
			xArray[size] = x;
			yArray[size] = y;
			size++;
			
		} else {
			System.out
					.println("Chat history is full. Please first remove elements from the chat before continuing.");
		}
	}
*/
	
	@Override
	/*public Label[] getObjectArray() {
		size = size();
		//Label[] textBoxArray = new Label[size];
		for (int i = 0; i < size; i++) {
			objectArray[i] = new TextLabel(xArray[i], yArray[i] -50 - 25 * i, 200, 20,
					StringArray[i].toString());
		}
		return (Label[]) objectArray;
	}
/*
	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		x = newVal;
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		y = newVal;
	}

	public void removeElement() {
		size = size();
		for (int i = 0; i < size; i++) {
			objectArray[i] = objectArray[i + 1];
		}
		size--;
	}
	public int size() {
		return size;
	}

	public void pop() {
		if (size > 0) {
			size--;
		} else {
			System.out.println("Chat history is empty. No elements to remove.");
		}
	}
	*/
	public void moveX(int newX){
		for (int i = 0; i<size; i++){
			xArray[i] = xArray[i] + newX;
		}
		setX(newX);
		setY(y);
	}
	public void moveY(int newY){
		for (int i = 0; i<size; i++){
			yArray[i] = yArray[i] + newY;
		}
		setY(newY);
		setX(x);
	}
}
