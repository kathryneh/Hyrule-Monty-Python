package chat;

public class chatHistory implements History {

	private int size = 0;
	final static int HISTORY_MAX_SIZE = 50;
	private String[] chatArray = new String[HISTORY_MAX_SIZE];
	private int x;
	private int y;

	public chatHistory(int x, int y, String element) {
		setX(x);
		setY(y);
		/*push("A man said to the universe:");
		push("'Sir I exist!'");
		push("'However,' replied the universe, ");
		push("'The fact has not created in me ");
		push("A sense of obligation.'");
		*/
		push(element);
		getObjectArray();
	}

	@Override
	public void push(String element) {
		if (size < HISTORY_MAX_SIZE) {
			chatArray[size] = element;
			size++;
		} else {
			System.out
					.println("Chat history is full. Please first remove elements from the chat before continuing.");
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void pop() {
		if (size > 0) {
			size--;
		} else {
			System.out.println("Chat history is empty. No elements to remove.");
		}
	}

	@Override
	public Label[] getObjectArray() {
		/*
		 * if (index>size){
		 * System.out.println("Not a valid index, please choose an index less than "
		 * + size); return null; }
		 */
		size = size();
		Label[] textBoxArray = new Label[size];
		for (int i = 0; i < size; i++) {
			textBoxArray[i] = new TextLabel(x, y - 25 * i, 200, 20,
					chatArray[i].toString());
		}
		return textBoxArray;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int newVal) {
		x = newVal + x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int newVal) {
		y = newVal + y;
	}

	@Override
	public void removeElement() {
		size = size();
		for (int i = 0; i < size; i++) {
			chatArray[i] = chatArray[i + 1];
		}
		size--;

	}
	public void moveX(int x){
		setX(x);
	}
	public void moveY(int y){
		setY(y);
	}
}
