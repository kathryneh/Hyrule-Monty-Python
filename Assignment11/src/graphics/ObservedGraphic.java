package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class ObservedGraphic extends Graphic implements ObservableGraphic{
	//ArrayList<GraphicsObserver> observers = new ArrayList<GraphicsObserver>();
	ArrayList<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	public ObservedGraphic(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@util.annotations.ObserverRegisterer(util.annotations.ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener){
		if(!listeners.contains(listener)){
			listeners.add(listener);
			System.out.println("Listener added" + listener);
			System.out.println("Listener class for property changes" + listener.getClass());
		}
	}

	@Override
	public void setX(int newX) {
		PropertyChangeEvent event = new PropertyChangeEvent(this, "x", this.newX, newX);
		this.newX = newX;
		notifyAllListeners(event);
		System.out.println("Class of PropertyChangeEvent:" + event.getClass());
		System.out.println("Graphics setX called");
	}
	@Override
	public void setY(int newY) {
		PropertyChangeEvent event = new PropertyChangeEvent(this, "y", this.newY, newY);
		this.newY = newY;
		notifyAllListeners(event);
		this.newY = newY;
		System.out.println("Graphics setY called");

	}

	public void notifyAllListeners(PropertyChangeEvent event) {
		for (int index = 0; index < listeners.size(); index++) {
			listeners.get(index).propertyChange(event);
			System.out.println("NotifyAllListeners called");
	}
	}


}
