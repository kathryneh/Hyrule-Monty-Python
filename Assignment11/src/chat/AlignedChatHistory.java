package chat;

import util.models.VectorChangeEvent;
import util.models.VectorListener;

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
	//int[] xArray = new int[ARRAY_MAX_SIZE];
	//int[] yArray = new int[ARRAY_MAX_SIZE];
	
	
	private boolean isFirstElement=true;
	int size = 0;
	public AlignedChatHistory(int x, int y) {
		super(x, y);
		xArray[0] = x;
	}

	/*public Label[] getObjectArray() {
		size = size();
		Label[] textBoxArray = new Label[size];
		for (int i = 0; i < size; i++) {
			textBoxArray[i] = new TextLabel(xArray[i], yArray[i], 200, 20,
					objectArray[i].toString());
			//textBoxArray[i] = new TextLabel(xArray[i], yArray[i] -50 - 25 * i, 200, 20,
		}
		return textBoxArray;
	}
	*/
	@Override
	public void push(int x, int y, String element) {
		if (size < ARRAY_MAX_SIZE) {
			//objectArray[size] = element;
			if (!isFirstElement && size>0){
				xArray[size] = xArray[0];
				//VectorChangeEvent event = new VectorChangeEvent(this, VectorChangeEvent.AddComponentEvent, listenerArrayList.size(), null, element, listenerArrayList.size() + 1);
				//objectArray[size] 
				Label newLabel= new TextLabel(xArray[size], y, 200, 20, element);
				super.push(newLabel);
				size++;
				//notifyAllListeners(event);
			}
			else if (isFirstElement){
				System.out.println("Adding to Chat History "+ element);
				xArray[size] = xArray[0];
				//VectorChangeEvent event = new VectorChangeEvent(this, VectorChangeEvent.AddComponentEvent, listenerArrayList.size(), null, element, listenerArrayList.size() + 1);
				//objectArray[size] = new TextLabel(xArray[size], y, 200, 20, element);
				Label newLabel= new TextLabel(xArray[size], y, 200, 20, element);
				super.push(newLabel);
				size++;
				//notifyAllListeners(event);
				isFirstElement = false;
			}

			yArray[size] = y;
			

		} else {
			System.out
			.println("Chat history is full. Please first remove elements from the chat before continuing.");
		}
	}

	public void moveX(int newX){
		for (int i = 0; i<size; i++){
			xArray[i] = xArray[i] + newX;
			int oldX = (((Label) objectArray[i]).getX());
			((Label) objectArray[i]).setX(newX + oldX);
		}
		System.out.println("Chat moveX called");
		setX(newX);
		setY(y);
	}
	public void moveY(int newY){
		for (int i = 0; i<size; i++){
			yArray[i] = yArray[i] + newY;
			int oldY = (((Label) objectArray[i]).getY());
			((Label) objectArray[i]).setY(newY + oldY);
			System.out.println("Chat moveY called");
		}
		setY(newY);
		setX(x);
	}
}
