package chat;

public interface Label {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);

	public int getWidth();

	public void setWidth(int newVal);

	public int getHeight();

	public void setHeight(int newVal);

	public String getText();

	public void setText(String newVal);

	public void setAnimatedX(int i);

	public void setAnimatedY(int i);
	
	//public void moveX(int x);
	//public void moveY(int y);
}