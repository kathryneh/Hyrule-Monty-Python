package chat;

public interface History {
	public void push(String element);

	public Label[] getObjectArray();

	public int size();

	public void pop();

	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);

	public void removeElement();
	
	public void moveX(int x);
	public void moveY(int y);

	/*
	 * public int getWidth(); //public String elementAt(int index); public void
	 * setWidth(int newVal); public int getHeight(); public void setHeight(int
	 * newVal); public String getText(); public void setText(String newVal);
	 */
}
