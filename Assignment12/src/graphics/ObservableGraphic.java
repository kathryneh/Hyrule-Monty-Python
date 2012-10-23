package graphics;

import java.beans.PropertyChangeEvent;


public interface ObservableGraphic extends Graphicable{
	//public void addObserver(String name, GraphicsObserver observer);
	//public void removeObserver(GraphicsObserver observer);
	
	void notifyAllListeners(PropertyChangeEvent event);
}
