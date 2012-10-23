package graphics;

/**
 * An interface for an object consisting of three lines that share endpoints.
 * Provides methods for obtaining these lines and the bounding box that
 * contains all three lines.
 * DO NOT EDIT THIS INTERFACE.
 * 
 * @author Wade Gobel
 */
public interface Triangle {
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public Line getLine1();
	public Line getLine2();
	public Line getLine3();
	public void setX(int x);
	public void setY(int y);
}