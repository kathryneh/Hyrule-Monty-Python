package avatars;

public class FallenCollection implements
Collectable {
	int size = 0;
	final static int FAC_MAX_SIZE = 50;
	Talkable[] avatarArray = new Talkable[FAC_MAX_SIZE];
	int x;
	int y;
	int removeElement = 0;

	public FallenCollection(int xloc, int yloc) {
		setX(xloc);
		setY(yloc);
		getAvatarArray();
	}

	public void push(int newX, int newY, String element, String type) {
		if (size < FAC_MAX_SIZE) {
			x=getX();
			y=getY();
			size = size();
			Talkable test;
			if(type.equals("guard")){
				test = new AlignedTalkingGuard(x-((size*50+50)+removeElement*50), y+90, element);
				//test.setY(-size*25);
				avatarArray[size] = test;
				//test2 = knightArray[index];
				size++;
			}
			else if (type.equals("knight")){
				test = new AlignedTalkingKnight(x-((size*50+50)+removeElement*50), y+90, element);
				//test.setY(-size*25);
				avatarArray[size] = test;
				//test2 = knightArray[index];
				size++;
			}
			//knightArray[index] = new TalkingKnightAvatar(x-(size*100+50), y+90, element);

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
		Talkable[] fallenArray = new Talkable[size];
		for (int i = 0; i < size; i++) {
			fallenArray[i] = avatarArray[i];
		}
		//}
		//return marchingKnightArray;
		return fallenArray;
	}

	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		x = newVal; //+ x;
		//test2.setX(newVal);
		//for (int i=0; i<size; i++){
		//	avatarArray[i].setX(newVal);
		//}
	}
	private void moveX(int newVal){
		for (int i=0; i<size; i++){
					avatarArray[i].moveX(newVal);
					avatarArray[i].setY(avatarArray[i].getY());
					
		}
	}

	public int getY() {
		return y;
	}
	public void setY(int newVal) {
		y = newVal; //+ y;
		//for (int i=0; i<size; i++){
			//(avatarArray[i]).setY(newVal);
		//}
	}
	public void removeElement() {
		size = size();
		for (int i = 0; i < size; i++) {
			avatarArray[i] = avatarArray[i + 1];
		}
		size--;
		moveX(50);
		removeElement++;


	}



	/*need to be able to add Knight or Guard
	 * should add an element to end
	 * remove last element added (LIFO)
	 * initial position determined by first added element
	 * after the first element, it no longer changes.
	 * no methods to move elements
	 * 
	 * 
	 * Need to restructure the code so that the interface
	 * for this class is extended by the interface AvatarCollection
	 * so that code is not reused and I'm not stuck overriding methods
	 * 
	 */

}
