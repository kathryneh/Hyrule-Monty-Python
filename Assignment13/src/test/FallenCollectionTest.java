package test;

import avatars.AlignedTalkingGuard;
import avatars.AlignedTalkingKnight;
import avatars.Collectable;
import avatars.Talkable;
import avatars.TalkingGuardAvatar;

public class FallenCollectionTest implements Collectable{
	protected int size = 0;
	final static int ARRAY_MAX_SIZE = 50;
	Talkable[] avatarArray = new Talkable[ARRAY_MAX_SIZE];
	protected int x;
	protected int y;
	protected int removeElement = 0;

	public FallenCollectionTest(int xloc, int yloc) {
		setX(xloc);
		setY(yloc);
	}
	public Talkable elementAt(int index) {
		return (Talkable) avatarArray[index];
	}
	@Override
	public void push(Talkable avatar){
		//if (avatar.getType() == "knight"){
		//avatarArray[size] = new AlignedTalkingKnight(avatar.getX(), avatar.getY(), avatar.getName());
		//size++;
		push(avatar.getName(),avatar.getType());
		System.out.println(avatar.getName() + avatar.getType());
		//}
		//else if (avatar.getType() == "guard"){
		//	avatarArray[size] = new AlignedTalkingGuard(avatar.getX(), avatar.getY(), avatar.getName());	
		//}
	}

	public void push(String element, String type) {
		if (size < ARRAY_MAX_SIZE) {
			x=getX();
			y=getY();
			size = size();
			Talkable test;
			if(type.equals("guard")){
				test = new AlignedTalkingGuard(x-((size*50)+removeElement*50), y, element);
				//test.setY(-size*25);
				avatarArray[size] = test;
				//test2 = knightArray[index];
				size++;
			}
			else if (type.equals("knight")){
				test = new AlignedTalkingKnight(x-((size*50)+removeElement*50), y, element);
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


	/*public Object[] getObjectArray() {
		/*
		 * if (index>size){
		 * System.out.println("Not a valid index, please choose an index less than "
		 * + size); return null; }
		 */
		//size = size();
		//Object[] fallenArray = new Object[size];
		//for (int i = 0; i < size; i++) {
		//	fallenArray[i] = (Talkable) avatarArray[i];
		//}
		//}
		//return marchingKnightArray;
		//return fallenArray;
	//}
	


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
	public int getY() {
		return y;
	}
	public void setY(int newVal) {
		y = newVal; //+ y;
		//for (int i=0; i<size; i++){
		//(avatarArray[i]).setY(newVal);
		//}
	}
	public void moveX(int newVal){
		for (int i=0; i<size; i++){
			((Talkable)avatarArray[i]).moveX(newVal);
			((Talkable)avatarArray[i]).setY(((Talkable)avatarArray[i]).getY());

		}
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
	public void pushFallen(AlignedTalkingKnight avatar){
		avatarArray[size] = avatar;
		((Talkable)avatarArray[size]).setX(550-size*50);
		((Talkable)avatarArray[size]).setY(550);
		((Talkable)avatarArray[size]).setChatX(265);
		((Talkable)avatarArray[size]).setChatY(300);
		//System.out.println((avatarArray[size].getChatHistory().getX()));
		//avatarArray[size].push(650, 500, "I've fallen!");

		//push(0,0, avatar.getName(),avatar.getType());
		//System.out.println(avatarArray[size].getName());
		size++;
		//size++;
	}
	public void pushFallenGuard(TalkingGuardAvatar avatar){
		avatarArray[size] = avatar;
		((Talkable)avatarArray[size]).setX(550-size*50);
		((Talkable)avatarArray[size]).setY(550);
		((Talkable)avatarArray[size]).setChatX(165);
		((Talkable)avatarArray[size]).setChatY(300);
		//System.out.println((avatarArray[size].getChatHistory().getX()));
		//avatarArray[size].push(650, 500, "I've fallen!");

		//push(0,0, avatar.getName(),avatar.getType());
		//System.out.println(avatarArray[size].getName());
		size++;
		//size++;
	}
	public boolean isFull() {
		if (size == ARRAY_MAX_SIZE){
			return true;
		}
		return false;
	}

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


