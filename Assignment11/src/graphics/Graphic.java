package graphics;


public abstract class Graphic implements Graphicable {

	protected int newX;
	protected int oldX;
	protected int oldY;
	protected int newY;
	protected int newWidth;
	protected int newHeight;
	
	public Graphic(int x, int y, int width, int height){
		newX = x;
		newY = y;
		newWidth = width;
		newHeight = height;
		
		setWidth(newWidth);
		setHeight(newHeight);
	}
	public int getX() {
		return newX;
	}
	public int getY() {
		return newY;
	}
	public void setX(int newX) {
		oldX = this.newX;
		this.newX = newX;
	}
	public void setY(int newY) {
		oldY = this.newY;
		this.newY = newY;
	}
	public int getWidth() {
		return newWidth;
	}
	public void setWidth(int newWidth) {
		this.newWidth = newWidth;
	}
	public int getHeight() {
		return newHeight;
	}
	public void setHeight(int newHeight) {
		this.newHeight = newHeight;
	}
	
}
