package graphics;

/**
 * A point in 2-dimensional Cartesian space.
 * DO NOT EDIT THIS CLASS.
 * 
 * @author Wade Gobel
 */
public class CartesianPoint implements Point {
	private int x;
	private int y;
	
	public CartesianPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}