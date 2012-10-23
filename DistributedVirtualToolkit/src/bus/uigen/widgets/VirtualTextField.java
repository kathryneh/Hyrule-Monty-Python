package bus.uigen.widgets;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;


public interface VirtualTextField extends VirtualTextComponent, VirtualActionableComponent {
	public static final String COMMAND_LABEL = "VIRTUALTEXTFIELD";
	public static final String ADD_ACTION_LISTENER_COMMAND = ".addActionListener(";
	public static final String BLOCK_ACTION_EVENT_FORWARDING_COMMAND = ".blockActionEventForwarding(";
	
	//public String getText();
	//public void setText (String theText);
	//public void addTextListener(Object listener);
	//public void addFocusListener(Object listener);
	public int getColumns() ;
	public void setColumns (int theNumber) ;
	public void postActionEvent();
	//public void setDocument (PlainDocument d);
	//public boolean isEditable();
	//public void setEditable(boolean newVal);
	
	//public void setBounds(int x, int y, int width, int height);
	
	
	public void addActionListener(VirtualActionListener listener);
	public void execAddActionListener(VirtualActionListener listener, String owner);
	
	public void removeActionListener(VirtualActionListener listener);
	
	
	public void setFocus(boolean focus);
	public void selectAll();
	
	public void addKeyUpHandler(Object handler);
	
	public void fireVirtualActionEvent(VirtualActionEvent event);
	
	public void blockActionEventForwarding(boolean block);
	public void execBlockActionEventForwarding(boolean block);
	
	public boolean isBlockingActionEventForwarding();
}
