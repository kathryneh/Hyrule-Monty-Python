package avatars;

import util.models.VectorChangeEvent;

public class AlignedSpacedCollection extends AlignedCollection implements
AvatarCollectable {
	public AlignedSpacedCollection(int xloc, int yloc) {
		super(xloc, yloc);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void push(String element, String type) {
		if (size < ARRAY_MAX_SIZE) {
			x=getX();
			y=getY();
			size = size();
			Talkable test;
			/*if(type.equals("guard")){
				test = new AlignedTalkingGuard(x-((size*50+50)+removeElement*50), y+90, element);
				//test.setY(-size*25);
				avatarArray[size] = test;
				//test2 = knightArray[index];
				size++;
			}
			else if (type.equals("knight")){
			 */
			test = new AlignedTalkingKnight((x-(size*50))+moveX, y+moveY, element);
			//test.setY(-size*25);
			objectArray[size] = test;
			//notifyAllListeners(new VectorChangeEvent(this, 1, al.size()-1, null, test, al.size()));
			//test2 = knightArray[index];
			size++;
		}
	}
	public void speakKnightAvatar(int x, int y, String element){
		((AlignedTalkingKnight)objectArray[0]).push(x, y, element);
		System.out.println("speakKnightAvatar ran");
	}
	
	public AlignedTalkingKnight leadingKnight(){
		return (AlignedTalkingKnight) objectArray[0];
	}
	
	public void pushFallen(AlignedTalkingKnight avatar){
		objectArray[size] = avatar;
		((Talkable)objectArray[size]).setX(550-size*50);
		((Talkable)objectArray[size]).setY(550);
		((Talkable)objectArray[size]).setChatX(265);
		((Talkable)objectArray[size]).setChatY(300);
		//notifyAllListeners(new VectorChangeEvent(this, 1, al.size()-1, null, avatar, al.size()));
		
		//System.out.println((avatarArray[size].getChatHistory().getX()));
		//avatarArray[size].push(650, 500, "I've fallen!");
		
		//push(0,0, avatar.getName(),avatar.getType());
		//System.out.println(avatarArray[size].getName());
		size++;
		//size++;
	}
	public void pushCrossed(AlignedTalkingKnight avatar){
		objectArray[size] = avatar;
		((Talkable)objectArray[size]).setX(675-size*50);
		((Talkable)objectArray[size]).setY(290);
		((Talkable)objectArray[size]).setChatX(390);
		((Talkable)objectArray[size]).setChatY(40);
		//notifyAllListeners(new VectorChangeEvent(this, 1, al.size()-1, null, avatar, al.size()));
		
		//push(0,0, avatar.getName(),avatar.getType());
		//System.out.println(avatarArray[size].getName());
		size++;
		//size++;
	}
}

