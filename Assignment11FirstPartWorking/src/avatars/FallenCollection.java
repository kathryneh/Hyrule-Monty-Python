package avatars;


public class FallenCollection extends generics.GenericCollection<Talkable> implements Collectable, generics.GenericCollectable<Talkable> {
	protected int size = 0;
	//final static int ARRAY_MAX_SIZE = 50;
	//Talkable[] objectArray = new Talkable[ARRAY_MAX_SIZE];
	protected int x;
	protected int y;
	protected int removeElement = 0;

	public FallenCollection(int xloc, int yloc) {
		setX(xloc);
		setY(yloc);
		//getAvatarArray();
	}
	

	@Override
	public Object[] getObjectArray() {
		return null;
	}
	@ Override
	public void push(Talkable avatar){
		//if (avatar.getType() == "knight"){
			//avatarArray[size] = new AlignedTalkingKnight(avatar.getX(), avatar.getY(), avatar.getName());
			//size++;
		push(avatar.getName(),avatar.getType());
		System.out.println(avatar.getName() + avatar.getType());
		//notifyAllListeners(new VectorChangeEvent(this, 1, al.size()-1, null, avatar, al.size()));
	
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
				this.objectArray[size] = test;
				//test2 = knightArray[index];
				size++;
			}
			else if (type.equals("knight")){
				test = new AlignedTalkingKnight(x-((size*50)+removeElement*50), y, element);
				//test.setY(-size*25);
				objectArray[size] = test;
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

			//notifyAllListeners(new VectorChangeEvent(this, 2, al.size()-1, null, al.size()));
		
			//for (int i=0; i<size; i++){
			//	(knightArray[i]).setX(200);

			size--;
		} else {
			System.out.println("Chat history is empty. No elements to remove.");
		}
	}
	
/*public Talkable[] getAvatarArray() {
	
		size = size();
		Talkable[] fallenArray = new Talkable[size];
		for (int i = 0; i < size; i++) {
			fallenArray[i] = (Talkable) objectArray[i];
		}
		return fallenArray;
	}
*/
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
	public void moveX(int newVal){
		for (int i=0; i<size; i++){
					((Talkable) objectArray[i]).moveX(newVal);
					((Talkable) objectArray[i]).setX(((Talkable) objectArray[i]).getX());
					
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
			objectArray[i] = objectArray[i + 1];
		}
		size--;
		moveX(50);
		removeElement++;


	}
	public void pushFallen(AlignedTalkingKnight avatar){
		objectArray[size] = avatar;
		((Talkable) objectArray[size]).setX(550-size*50);
		((Talkable) objectArray[size]).setY(550);
		((Talkable) objectArray[size]).setChatX(265);
		((Talkable) objectArray[size]).setChatY(300);
		//System.out.println((avatarArray[size].getChatHistory().getX()));
		//avatarArray[size].push(650, 500, "I've fallen!");
		
		//push(0,0, avatar.getName(),avatar.getType());
		//System.out.println(avatarArray[size].getName());
		size++;
		//size++;
	}
	public void pushFallenGuard(TalkingGuardAvatar avatar){
		objectArray[size] = avatar;
		((Talkable)objectArray[size]).setX(550-size*50);
		((Talkable)objectArray[size]).setY(550);
		((Talkable)objectArray[size]).setChatX(165);
		((Talkable)objectArray[size]).setChatY(300);
		//System.out.println((avatarArray[size].getChatHistory().getX()));
		//avatarArray[size].push(650, 500, "I've fallen!");
		
		//push(0,0, avatar.getName(),avatar.getType());
		//System.out.println(avatarArray[size].getName());
		size++;
		//size++;
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
