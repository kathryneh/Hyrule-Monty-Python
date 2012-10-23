package avatars;

public class AlignedCollection extends FallenCollection implements
AvatarCollectable {
	int moveX = 0;
	int moveY = 0;
	public AlignedCollection(int xloc, int yloc) {
		super(xloc, yloc);
		// TODO Auto-generated constructor stub
	}

	public void moveX(int newVal){
		moveX = moveX + newVal;
		for (int i=0; i<size; i++){
			avatarArray[i].moveX(newVal);
		}
	}
	public void moveY(int newVal){
		moveY = moveY + newVal;
		for (int i=0; i<size; i++){
			(avatarArray[i]).moveY(newVal);
		}
	}

	@Override
	public void push(int newX, int newY, String element, String type) {
		if (size < FAC_MAX_SIZE) {
			x=getX();
			y=getY();
			size = size();
			Talkable test;
			test = new AlignedTalkingKnight(newX, newY, element);
			//test.setY(-size*25);
			avatarArray[size] = test;
			//test2 = knightArray[index];
			size++;
		}


	}
}
