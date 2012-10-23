package graphics;

/**
 * A line segment in 2-dimensional Cartesian space.
 * DO NOT EDIT THIS CLASS.
 * 
 * @author Wade Gobel
 */
public class CartesianLine implements Line {
	
	private Point point;
	private int width;
	private int height;
	
	public CartesianLine(int x, int y, int width, int height) {
		this.point = new CartesianPoint(x,y);
		this.width = width;
		this.height = height;
	}
	
	public Point getLocation() {
		return point;
	}
	
	public int getX() {
		return point.getX();
	}
	
	public int getY() {
		return point.getY();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setX(int x) {
		point.setX(x);
	}
	
	public void setY(int y) {
		point.setY(y);
	}
}