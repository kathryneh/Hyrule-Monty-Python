package avatars;

public interface Collectable {
	public Talkable[] getAvatarArray();

	public int size();

	public void pop();

	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);

	public void removeElement();

	public void push(int x, int y, String element, String type);
}
