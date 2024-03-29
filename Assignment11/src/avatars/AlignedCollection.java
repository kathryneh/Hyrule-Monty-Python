package avatars;
/**
 * This is an abstract class containing much of the gut of the "AllignedSpacedCollection" class.
 * @author kathryne
 *
 */
public abstract class AlignedCollection extends FallenCollection implements
AvatarCollectable {
	protected int moveX = 0;
	protected int moveY = 0;
	public AlignedCollection(int xloc, int yloc) {
		super(xloc, yloc);
	}

	/**
	 * This is for the AllignedSpacedCollection class; 
	 * The object is moved by a certain value and it is added to the old value. 
	 * It also calls the super setX method and calls a listener. 
	 */
	public void moveX(int newVal){
		moveX = moveX + newVal;
		setX(moveX);
		for (int i=0; i<size; i++){
			((Talkable)objectArray[i]).moveX(newVal);
			
		}
	}
	/**
	 * This is for the AllignedSpacedCollection class; 
	 * The object is moved by a certain value and it is added to the old value. 
	 * It also calls the super setY method and calls a listener. 
	 */
	public void moveY(int newVal){
		moveY = moveY + newVal;
		setY(moveY);
		for (int i=0; i<size; i++){
			((Talkable)objectArray[i]).moveY(newVal);
		}
	}

//	@Override
/*
	public void push(String element, String type) {
		if (size < ARRAY_MAX_SIZE) {
			x=getX();
			y=getY();
			size = size();
			Talkable test;
			test = new AlignedTalkingKnight(x, y, element);
			//test.setY(-size*25);
			objectArray[size] = test;
			//test2 = knightArray[index];
			size++;
		}

*/
	
}
