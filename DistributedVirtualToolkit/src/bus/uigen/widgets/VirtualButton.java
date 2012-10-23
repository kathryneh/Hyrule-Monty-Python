package bus.uigen.widgets;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;


public interface VirtualButton extends VirtualActionableComponent, VirtualLabel {
	public static final String COMMAND_LABEL = "VIRTUALBUTTON:";
	public static final String ADD_ACTION_LISTENER_COMMAND = ".addActionListener(";
	public static final String BLOCK_ACTION_EVENT_FORWARDING_COMMAND = ".blockActionEventForwarding(";
	
	//public void addActionListener (Object listener);
	public void setMargin (Object margin);
	public void setActionCommand (String command);
	public void pack();
	public String getLabel();
	
	
	public void addActionListener(VirtualActionListener listener);
	public void execAddActionListener(VirtualActionListener listener, String creator);
	
	
	public void removeActionListener(VirtualActionListener listener);
	
	
	public void addStyleName(String name);
	public void setFocus(boolean focus);
	
	public void addClickHandler(Object handler);
	
	public void fireVirtualActionEvent(VirtualActionEvent event);
	
	public void blockActionEventForwarding(boolean block);
	public void execBlockActionEventForwarding(boolean block);
	
	
	public boolean isBlockingActionEventForwarding();
}
