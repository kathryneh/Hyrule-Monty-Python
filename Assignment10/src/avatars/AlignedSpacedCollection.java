package avatars;

public class AlignedSpacedCollection extends AlignedCollection implements
AvatarCollectable {
	public AlignedSpacedCollection(int xloc, int yloc) {
		super(xloc, yloc);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void push(int newX, int newY, String element, String type) {
		if (size < FAC_MAX_SIZE) {
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
			avatarArray[size] = test;
			//test2 = knightArray[index];
			size++;
		}
	}
	public void speakKnightAvatar(int x, int y, String element){
		((AlignedTalkingKnight)avatarArray[0]).push(x, y, element);
		System.out.println("speakKnightAvatar ran");
	}
	
	public AlignedTalkingKnight leadingKnight(){
		return (AlignedTalkingKnight) avatarArray[0];
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
	public void pushCrossed(AlignedTalkingKnight avatar){
		avatarArray[size] = avatar;
		((Talkable)avatarArray[size]).setX(675-size*50);
		((Talkable)avatarArray[size]).setY(290);
		((Talkable)avatarArray[size]).setChatX(390);
		((Talkable)avatarArray[size]).setChatY(40);
		//push(0,0, avatar.getName(),avatar.getType());
		//System.out.println(avatarArray[size].getName());
		size++;
		//size++;
	}
}

