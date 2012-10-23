package graphics;

/**
 * An interface for a line object with a point location,
 * and a bounding box described by width and height.
 * DO NOT EDIT THIS INTERFACE.
 * 
 * @author Wade Gobel
 */
public interface Line {
	public Point getLocation();
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public void setX(int x);
	public void setY(int y);
}