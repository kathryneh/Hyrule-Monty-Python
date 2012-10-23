package graphics;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyChangeEvent;

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
	
	List<PropertyChangeListener> listeners;
	
	protected CartesianShape() {
		this(0,0,0,0);
	}
	
	protected CartesianShape(int x, int y, int width, int height) {
		this.location = new CartesianPoint(x,y);
		this.width = width;
		this.height = height;
		listeners = new ArrayList<PropertyChangeListener>();
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
		int oldVal = location.getX();
		location.setX(x);
		notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal, x));
	}
	
	public void setY(int y) {
		int oldVal = location.getY();
		location.setY(y);
		notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal, y));
	}

	public void addPropertyChangeListener(PropertyChangeListener newListener){
		if(!listeners.contains(newListener))
		{
			listeners.add(newListener);
		}
	}

	private void notifyAllListeners(PropertyChangeEvent event){
		for(int i = 0; i < listeners.size(); i++)
			listeners.get(i).propertyChange(event);
	}
}
