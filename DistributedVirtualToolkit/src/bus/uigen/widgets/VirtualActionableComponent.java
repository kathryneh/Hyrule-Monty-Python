package bus.uigen.widgets;

public interface VirtualActionableComponent /*extends VirtualComponent*/ { //formerly extends VirtualComponent was commented out
	
	//public void addActionListener (ActionListener listener);
	public void postEvent(Object event);
	
	

}
