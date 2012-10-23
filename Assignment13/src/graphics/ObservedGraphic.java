package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public abstract class ObservedGraphic extends Graphic implements ObservableGraphic, Animatable{
	//ArrayList<GraphicsObserver> observers = new ArrayList<GraphicsObserver>();
	ArrayList<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	
	public ObservedGraphic(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@util.annotations.ObserverRegisterer(util.annotations.ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener){
		if(!listeners.contains(listener)){
			listeners.add(listener);
			//System.out.println("Listener added" + listener);
			//System.out.println("Listener class for property changes" + listener.getClass());
		}
	}

	@Override
	public void setUnanimatedX(int newX) {
		PropertyChangeEvent event = new PropertyChangeEvent(this, "x", this.newX, newX);
		this.newX = newX;
		notifyAllListeners(event);
		//System.out.println("Class of PropertyChangeEvent:" + event.getClass());
		//System.out.println("Graphics setX called");

	}
	public void notifyAllListeners(PropertyChangeEvent event) {
		for (int index = 0; index < listeners.size(); index++) {
			listeners.get(index).propertyChange(event);
			//System.out.println("NotifyAllListeners called");
	}
	}
	@Override
	public void setUnanimatedY(int newY) {
		PropertyChangeEvent event = new PropertyChangeEvent(this, "y", this.newY, newY);
		this.newY = newY;
		notifyAllListeners(event);
		this.newY = newY;
		//System.out.println("Graphics setY called");
	}
	
	public void animateSetX(int newX){
		//Create a new ASetXCommand instance and a new thread then start the thread.
		Runnable animateCommand = new ASetXCommand(this, newX, Animation.numSteps, Animation.amountPauseTime);
		Thread thread = new Thread(animateCommand);
		thread.setName("Set X Animation");
		thread.start();
	}
	
	public void animateSetY(int newY){
		//create a new ASetYCommand and a new Thread and then start the thread.
		Runnable animateCommand = new ASetYCommand(this, newY, Animation.numSteps, Animation.amountPauseTime);
		Thread thread = new Thread(animateCommand);
		thread.setName("Set Y Animation");
		thread.start();
	}

	
	public void sleep(int pauseTime) {
		try {
			// OS suspends program for pauseTime
			Thread.sleep(pauseTime);
			System.out.println("System is sleeping");
		} catch (InterruptedException e) {
			// program may be forcibly interrupted while sleeping
			e.printStackTrace();
		}
	}
	
	public synchronized void animateSetX(int newX, int steps, int pauseTime){
		//get the old value and then create a loop which goes through "steps" steps
		// calculate a current x value, calling this.setX on the new current value 
		// then call sleep.
		int oldX = getX();
		int currentX = oldX;
		System.out.println("OldX: " + oldX);
		double dX = (newX-oldX)/steps;
		System.out.println("dX:" + dX);
		for (int i = 0; i < steps; i++){
			currentX += dX;
			this.setUnanimatedX(currentX);
			System.out.println("Synchronized set X called");
			sleep(pauseTime);
		}
		
	}
	
	public synchronized void animateSetY(int newY, int steps, int pauseTime){
		int oldY = getY();
		int currentY = oldY;
		double dY = (newY-oldY)/steps;
		for (int i =0; i<steps; i++){
			currentY+=dY;
			this.setUnanimatedY(currentY);
			sleep(pauseTime);
		}
	}


}
