package avatars;


public abstract class KnightCollection implements AvatarCollectable {
	private int size = 0;
	final static int KAC_MAX_SIZE = 50;
	private TalkingKnightAvatar[] knightArray = new TalkingKnightAvatar[KAC_MAX_SIZE];
	private int x;
	private int y;
	private int removeElement = 0;
	//private TalkingKnightAvatar test2;
	

	public KnightCollection(int xloc, int yloc) {
		setX(xloc);
		setY(yloc);
		/*push("A man said to the universe");
		push("Sir, I exist!");
		push("However, the universe said,");
		push("That fact has not created in me");
		push("A sense of obligation");
		*/
		getAvatarArray();
	}
	
	public void speakKnightAvatar(String element){
		knightArray[0].push(0, 0, element);
	}
	
	public void push(int x, int y, String element, String useless) {
		if (size < KAC_MAX_SIZE) {
			x = getX();
			y = getY();
			size = size();
			AlignedTalkingKnight test = new AlignedTalkingKnight(x-((size*50+50)+removeElement*50), y-90, element);
			//knightArray[index] = new TalkingKnightAvatar(x-(size*100+50), y+90, element);
			knightArray[size] = test;
			//test2 = knightArray[index];
			size++;
		} else {
			System.out.println("Chat history is full. Please first remove elements from the chat before continuing.");
		}
	}

	public int size() {
		return size;
	}

	public void pop() {
		if (size > 0) {
			
			//for (int i=0; i<size; i++){
			//	(knightArray[i]).setX(200);
			
			size--;
		} else {
			System.out.println("Chat history is empty. No elements to remove.");
		}
	}

	public Talkable[] getAvatarArray() {
		/*
		 * if (index>size){
		 * System.out.println("Not a valid index, please choose an index less than "
		 * + size); return null; }
		 */
		size = size();
		TalkingKnightAvatar[] marchingKnightArray = new TalkingKnightAvatar[size];
		for (int i = 0; i < size; i++) {
			marchingKnightArray[i] = knightArray[i];
		}
		//}
		//return marchingKnightArray;
		return marchingKnightArray;
	}

	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		x = newVal;
		//test2.setX(newVal);
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		y = newVal + y;
	}
	public void removeElement() {
		size = size();
		for (int i = 0; i < size; i++) {
			knightArray[i] = knightArray[i + 1];
		}
		size--;
		moveX(50);
		removeElement++;
		

	}

	public void moveX(int newVal){
		for (int i=0; i<size; i++){
			knightArray[i].moveX(newVal);
		}
	}
	public void moveY(int newVal){
		for (int i=0; i<size; i++){
			(knightArray[i]).moveY(newVal);
		}
	}


}
