package graphics;

/**
 * A graphics object in Cartesian space that possesses
 * an upper left corner and a bounding box.
 * DO NOT EDIT THIS CLASS IN RECITATION.
 * Feel free to edit this class if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public abstract class CartesianShape implements Shape {

	protected Point location;
	protected int width;
	protected int height;
	
	protected CartesianShape() {
		this(0,0,0,0);
	}
	
	protected CartesianShape(int x, int y, int width, int height) {
		this.location = new CartesianPoint(x,y);
		this.width = width;
		this.height = height;
	}
	
	public int getX() {
		return location.getX();
	}
	
	public int getY() {
		return location.getY();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setX(int x) {
		location.setX(x);
	}
	
	public void setY(int y) {
		location.setY(y);
	}
}