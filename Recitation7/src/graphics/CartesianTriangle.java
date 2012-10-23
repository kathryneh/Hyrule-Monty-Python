package graphics;

/**
 * An object that consists of 3 lines that share endpoints
 * in 2-dimensional Cartesian space.
 * 
 * @author Wade Gobel
 */
public class CartesianTriangle implements Triangle {

	// the bounding box that contains this triangle
	private Point location;
	private int width;
	private int height;
	// the lines that make up the triangle
	private Line line1;
	private Line line2;
	private Line line3;
	
	public CartesianTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		location = new CartesianPoint(findMin(x1,x2,x3),findMin(y1,y2,y3));
		width = -(location.getX() + findMin(-x1,-x2,-x3));
		height = -(location.getY() + findMin(-y1,-y2,-y3));
		line1 = new CartesianLine(x1, y1, x2 - x1, y2 - y1);
		line2 = new CartesianLine(x2, y2, x3 - x2, y3 - y2);
		line3 = new CartesianLine(x3, y3, x1 - x3, y1 - y3);
	}
	
	private int findMin(int a, int b, int c) {
		int min = a;
		if(min > b) {
			min = b;
		}
		if(min > c) {
			min = c;
		}
		return min;
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
	
	public Line getLine1() {
		return line1;
	}
	
	public Line getLine2() {
		return line2;
	}
	
	public Line getLine3() {
		return line3;
	}
	
	public void setX(int x) {
		int dx = x - getX();
		location.setX(location.getX() + dx);
		line1.setX(line1.getX() + dx);
		line2.setX(line2.getX() + dx);
		line3.setX(line3.getX() + dx);
	}
	
	public void setY(int y) {
		int dy = y - getY();
		location.setY(location.getY() + dy);
		line1.setY(line1.getY() + dy);
		line2.setY(line2.getY() + dy);
		line3.setY(line3.getY() + dy);
	}
}