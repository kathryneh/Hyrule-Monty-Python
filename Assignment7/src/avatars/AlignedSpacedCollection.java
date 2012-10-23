package avatars;

public class AlignedSpacedCollection extends AlignedCollection implements
AvatarCollectable {
	int moveX = 0;
	int moveY = 0;
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
			test = new AlignedTalkingKnight((x-(size*50+50))+moveX, y+90+moveY, element);
			//test.setY(-size*25);
			avatarArray[size] = test;
			//test2 = knightArray[index];
			size++;
		}


	}
}

