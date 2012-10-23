package graphics;

import java.beans.PropertyChangeListener;

/**
 * An interface for a resizable line object with a point location,
 * and a bounding box described by width and height.
 * DO NOT EDIT THIS INTERFACE IN RECITATION.
 * Feel free to edit this interface if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public interface Line extends ResizableShape {
	public void addPropertyChangeListener(PropertyChangeListener newListener);
	public void animateSetX(int newX);
	public void animateSetY(int newY);
	public void animateSetX(int newX, int steps, int pauseTime);
	public void animateSetY(int newY, int steps, int pauseTime);
}