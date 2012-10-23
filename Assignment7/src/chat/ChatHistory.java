package chat;

public class ChatHistory implements History {

	protected int size = 0;
	final static int HISTORY_MAX_SIZE = 50;
	protected String[] chatArray = new String[HISTORY_MAX_SIZE];
	int[] xArray = new int[HISTORY_MAX_SIZE];
	int[] yArray = new int[HISTORY_MAX_SIZE];
	protected int x;
	protected int y;

	public ChatHistory(int x, int y, String element) {
		setX(x);
		setY(y);
		/*push("A man said to the universe:");
		push("'Sir I exist!'");
		push("'However,' replied the universe, ");
		push("'The fact has not created in me ");
		push("A sense of obligation.'");
		*/
		push(x, y, element);
		getObjectArray();
	}

	public void push(int x, int y, String element) {
		if (size < HISTORY_MAX_SIZE) {
			chatArray[size] = element;
			xArray[size] = x;
			yArray[size] = y;
			size++;
			
		} else {
			System.out
					.println("Chat history is full. Please first remove elements from the chat before continuing.");
		}
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

	public Label[] getObjectArray() {
		size = size();
		Label[] textBoxArray = new Label[size];
		for (int i = 0; i < size; i++) {
			textBoxArray[i] = new TextLabel(xArray[i], yArray[i] -50 - 25 * i, 200, 20,
					chatArray[i].toString());
		}
		return textBoxArray;
	}

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
			chatArray[i] = chatArray[i + 1];
		}
		size--;

	}
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
