package bus.uigen.widgets.awt;

//import java.awt.Component;
//import java.awt.Container;
import java.awt.Button;
import java.awt.Event;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.Icon;

import bus.uigen.distributed.client.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;

public class AWTButton extends AWTComponent  implements VirtualButton {
	//AbstractButton getButton();
	protected Map<VirtualActionListener,String> vActionListeners = new HashMap<VirtualActionListener,String>();
	boolean blockActionEvents;
	
	public AWTButton (Button theButton) {
		super (theButton);
		//getButton() = theButton;	
		
		//init();
		
	}
	
	public AWTButton() {
		component = new Button();
	}
	
	public void init(){
		super.init();
		getButton().addActionListener(new AWTButtonEventForwarder(this));
	}
	
	
	public Set<VirtualActionListener> getVirtualActionListeners(){
		return vActionListeners.keySet();
	}
	
	public Button getButton() {
		return (Button) component;
	}
	
	
	
	public void setActionCommand (String command) {		
		getButton().setActionCommand(command);
	}
	public String getText() {
		return getButton().getLabel();
	}
	public void setText (String theText) {
		getButton().setLabel(theText);
	}
	public void setIcon (Object theIcon) {
		setIcon( (Icon)  theIcon);
	}
	public void setIcon (Icon theIcon) {
		getButton().setLabel( theIcon.toString());
	}
	public void setMargin (Insets margin) {
		System.out.println("Margins cannot be set for Button");
		//getButton().setMargin(margin);
	}
	public void setVerticalAlignment(int alignment) {
		System.out.println("Alignment cannot be set for Button");
		//getButton().setVerticalAlignment(alignment);
		
	}
	public void setHorizontalAlignment (int alignment) {
		System.out.println("Alignment cannot be set for Button");
		//getButton().setHorizontalAlignment(alignment);
	}
	public String getLabel()  {		
		return getButton().getLabel();
	}
	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getButton().postEvent(event);
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
	
	public void execAddActionListener(VirtualActionListener listener, String creator){
		vActionListeners.put(listener, creator);
	}
	
	public String getOwner(VirtualActionListener listener){
		return vActionListeners.get(listener);
	}
	
	public void addActionListener (Object theListener) {
		addActionListener((ActionListener) theListener);
		
	}
	/*public void addActionListener (ActionListener theListener) {
		getButton().addActionListener(theListener);
		
	}*/
	public void setMargin(Object margin) {
		setMargin((Insets) margin);
	}
	public static AWTButton virtualButton (Button theButton) {	
		return (AWTButton) AWTComponent.virtualComponent(theButton);		
			
	}

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

	
	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
	}
	
	public void fireVirtualActionEvent(VirtualActionEvent event){
		
		Iterator<VirtualActionListener> listeners = getVirtualActionListeners().iterator();
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
}
