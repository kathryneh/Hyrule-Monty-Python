package graphics;

/**
 * An interface for a graphics object that possesses
 * an upper left corner and a bounding box
 * whose dimensions can be resized.
 * DO NOT EDIT THIS INTERFACE IN RECITATION.
 * Feel free to edit this interface if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public interface ResizableShape extends Shape {
	public void setWidth(int width);
	public void setHeight(int height);
}