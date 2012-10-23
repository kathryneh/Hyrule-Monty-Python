package chat;

public class AlignedChatHistory extends ChatHistory implements History {
/*
 * create a subtype that ensures elements all have the same x
 * basically, make it so it ignores the x of added labels and
 * does what it wants.
 * 
 * 
 * then, subtype talking avatars with these. 
 * Also, subtype the knight avatar collection.
 * 
 */
	private boolean isFirstElement=true;
	
	public AlignedChatHistory(int x, int y) {
		super(x, y);
		xArray[0] = x;
	}

	@Override
	public Label[] getObjectArray() {
		size = size();
		Label[] textBoxArray = new Label[size];
		for (int i = 0; i < size; i++) {
			textBoxArray[i] = new TextLabel(xArray[i], yArray[i], 200, 20,
					objectArray[i].toString());
			//textBoxArray[i] = new TextLabel(xArray[i], yArray[i] -50 - 25 * i, 200, 20,
		}
		return textBoxArray;
	}
	
	@Override
	public void push(int x, int y, String element) {
		if (size < ARRAY_MAX_SIZE) {
			objectArray[size] = element;
			if (!isFirstElement && size>0){
				xArray[size] = xArray[0];
			}
			else if (isFirstElement){
			xArray[size] = xArray[0];
			isFirstElement = false;
			}
			
			yArray[size] = y;
			size++;
			
		} else {
			System.out
					.println("Chat history is full. Please first remove elements from the chat before continuing.");
		}
	}
}
