package graphics;

public class Graphic implements Graphicable {

	int newX;
	int newY;
	int newWidth;
	int newHeight;
	
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
		this.newX = newX;
	}
	public void setY(int newY) {
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
