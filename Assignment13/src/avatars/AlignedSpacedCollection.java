package avatars;


public class AlignedSpacedCollection extends AlignedCollection implements
AvatarCollectable {
	public AlignedSpacedCollection(int xloc, int yloc) {
		super(xloc, yloc);
	}
	@Override
	public void push(String element) {
		if (size < ARRAY_MAX_SIZE) {
			x=getX();
			y=getY();
			size = size();
			Talkable test;
			test = new AlignedTalkingKnight((x-(size*50))+moveX, y+moveY, element);
			objectArray[size] = test;
			size++;
		}
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
	public void speakKnightAvatar(int x, int y, String element){
		((AlignedTalkingKnight)objectArray[0]).push(x, y, element);
		System.out.println("speakKnightAvatar ran");
	}
	
	public AlignedTalkingKnight leadingKnight(){
		return (AlignedTalkingKnight) objectArray[0];
	}
	public void removeAnimatedElement() {
		size = size();
		for (int i = 0; i < size; i++) {
			objectArray[i] = objectArray[i + 1];
		}
		size--;
		moveAnimatedX(50);
		removeElement++;
	}
	

	
/*	public void pushFallen(AlignedTalkingKnight avatar){
		objectArray[size] = avatar;
		((Talkable)objectArray[size]).setX(550-size*50);
		((Talkable)objectArray[size]).setY(550);
		((Talkable)objectArray[size]).setChatX(265);
		((Talkable)objectArray[size]).setChatY(300);
		size++;
	}
	public void pushCrossed(AlignedTalkingKnight avatar){
		objectArray[size] = avatar;
		((Talkable)objectArray[size]).setX(675-size*50);
		((Talkable)objectArray[size]).setY(290);
		((Talkable)objectArray[size]).setChatX(390);
		((Talkable)objectArray[size]).setChatY(40);
		size++;
	}
*/
}

