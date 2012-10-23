package graphics;

/**
 * An interface for a graphics object that possesses
 * an upper left corner and a bounding box.
 * DO NOT EDIT THIS INTERFACE IN RECITATION.
 * Feel free to edit this interface if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public interface Shape {
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public void setX(int x);
	public void setY(int y);
}