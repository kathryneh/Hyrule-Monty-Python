package avatars;

public interface Collectable {
	//public Object[] getObjectArray();
	//public int size();
	//public void pop();
	//public int getX();
	//public void setX(int newVal);
	//public int getY();
	//public void setY(int newVal);
	//public void removeElement();

	public void push(String element, String type);
	public void push(Talkable avatar);
//	public void moveX(int newVal);
	public void pushFallen(AlignedTalkingKnight avatar);
	public void pushFallenGuard(TalkingGuardAvatar avatar);
}
