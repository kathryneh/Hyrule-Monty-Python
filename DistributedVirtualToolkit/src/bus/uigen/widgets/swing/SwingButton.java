package bus.uigen.widgets.swing;

import java.awt.Event;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;

import bus.uigen.distributed.client.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;

public class SwingButton extends SwingComponent  implements VirtualButton {
	
	Map<VirtualActionListener, String> vActionListeners = new HashMap<VirtualActionListener, String>();
	boolean blockActionEvents;
	
	public SwingButton (AbstractButton theButton) {
		super (theButton);
		//getButton() = theButton;	
		
	}
	
	AbstractButton getButton() {
		return (AbstractButton) component;
	}
	
	public SwingButton() {
		
	}
	
	public void init(){
		getButton().addActionListener(new SwingButtonEventForwarder(this));
		super.init();
	}
	
	public Set<VirtualActionListener> getVirtualActionListeners(){
		return vActionListeners.keySet();
	}
	public void setActionCommand (String command) {
		getButton().setActionCommand(command);
	}
	public String getText() {
		return getButton().getText();
	}
	public void setText (String theText) {
		getButton().setText(theText);
	}
	public void setIcon (Object theIcon) {
		getButton().setIcon( (Icon)  theIcon);
	}
	public void setIcon (Icon theIcon) {
		getButton().setIcon( theIcon);
	}
	public void setMargin (Insets margin) {
		getButton().setMargin(margin);
	}
	public void setVerticalAlignment(int alignment) {
		getButton().setVerticalAlignment(alignment);
		
	}
	public void setHorizontalAlignment (int alignment) {
		getButton().setHorizontalAlignment(alignment);
	}
	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getButton().postEvent(event);
	}
	@SuppressWarnings("deprecation")
	public String getLabel()  {
		return getButton().getLabel();
	}
	public void setMargin(Object margin) {
		getButton().setMargin((Insets) margin);
	}
	public static SwingButton virtualButton (JButton theButton) {	
		return (SwingButton) AWTComponent.virtualComponent(theButton);		
			
	}

	//@Override
	public void pack() {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClickHandler(Object handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStyleName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub
		
	}
	
	public void addActionListener(VirtualActionListener listener){

		execAddActionListener(listener, VirtualToolkit.getUniqueID());
		
		if(VirtualToolkit.isDistributed() && !(listener instanceof ActionEventForwarder) ){
			String listenerID = VirtualToolkit.getObjectID(VirtualListener.class);
			VirtualToolkit.sendListener(listener, listenerID);
			
			String uniqueID = VirtualToolkit.getUniqueID();
			String command = VirtualButton.COMMAND_LABEL + this.getID() + VirtualButton.ADD_ACTION_LISTENER_COMMAND + uniqueID + "," + listenerID + "," + VirtualToolkit.getUniqueID() + ")";
			VirtualToolkit.sendCommand(command);
		}
	}
	
	public void execAddActionListener(VirtualActionListener listener, String owner){
		vActionListeners.put(listener, owner);
		
	}

	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
	}
	
	public void fireVirtualActionEvent(VirtualActionEvent event){
		Iterator<VirtualActionListener> listeners = vActionListeners.keySet().iterator();
		while(listeners.hasNext()){
			VirtualActionListener listener = listeners.next();
			if(! (listener instanceof ActionEventForwarder)){
				listener.actionPerformed(event);
			}
		}
	}

	public void blockActionEventForwarding(boolean block){
		execBlockActionEventForwarding(block);
		if(VirtualToolkit.isDistributed()){
			String uniqueID = VirtualToolkit.getUniqueID();
			String command = VirtualButton.COMMAND_LABEL + this.getID() + BLOCK_ACTION_EVENT_FORWARDING_COMMAND + uniqueID + "," + block +")";
			VirtualToolkit.sendCommand(command);
		}
	}
	
	public void execBlockActionEventForwarding(boolean block){
		this.blockActionEvents = block;
	}
	
	public boolean isBlockingActionEventForwarding() {
		return this.blockActionEvents;
	}
	
	public String getOwner(VirtualActionListener listener){
		return vActionListeners.get(listener);
	}

}
