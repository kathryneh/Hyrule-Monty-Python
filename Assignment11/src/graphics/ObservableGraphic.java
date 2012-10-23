package graphics;

import java.beans.PropertyChangeEvent;


public interface ObservableGraphic extends Graphicable{
	//public void addObserver(String name, GraphicsObserver observer);
	//public void removeObserver(GraphicsObserver observer);
	public void setX(int newY);
	public void setY(int newX);
	void notifyAllListeners(PropertyChangeEvent event);
}
