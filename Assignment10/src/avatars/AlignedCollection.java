package avatars;

public abstract class AlignedCollection extends FallenCollection implements
AvatarCollectable {
	protected int moveX = 0;
	protected int moveY = 0;
	public AlignedCollection(int xloc, int yloc) {
		super(xloc, yloc);
		// TODO Auto-generated constructor stub
	}

	public void moveX(int newVal){
		moveX = moveX + newVal;
		setX(moveX);
		for (int i=0; i<size; i++){
			((Talkable)avatarArray[i]).moveX(newVal);
		}
	}
	public void moveY(int newVal){
		moveY = moveY + newVal;
		setY(moveY);
		for (int i=0; i<size; i++){
			((Talkable)avatarArray[i]).moveY(newVal);
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
