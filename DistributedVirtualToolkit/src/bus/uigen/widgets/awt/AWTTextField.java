package bus.uigen.widgets.awt;

import java.awt.TextField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import bus.uigen.distributed.client.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;

public class AWTTextField extends AWTTextComponent implements VirtualTextField {
	//JTextField getTextField();
	
	Map<VirtualActionListener, String> vActionListeners = new HashMap<VirtualActionListener, String>();
	boolean blockActionEvents;
	
	public AWTTextField (TextField theTextField) {
		super (theTextField);
		//getTextField() = theTextField;		
		
	}
	
	public AWTTextField(String text){
		super(new TextField(text));
		System.out.println(getTextField().getText());
	}
	
	public AWTTextField() {
		super(new TextField());
	}
	
	public void init(){
		super.init();
		getTextField().addActionListener(new AWTTextFieldEventForwarder(this));
	}
	
	public Set<VirtualActionListener> getVirtualActionListeners(){
		return vActionListeners.keySet();
	}
	
	public TextField getTextField() {
		return (TextField) component;
	}
	
	public int getColumns() {
		return getTextField().getColumns();
	}
	public void setColumns (int theNumber) {
		getTextField().setColumns(theNumber);
	}
	
	public void postActionEvent() {
		System.out.println("Post Event Not Defined for Text Field");
		//getTextField().postActionEvent();
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
	
	public String getOwner(VirtualActionListener listener){
		return vActionListeners.get(listener);
	}
	
	
	public void removeActionListener(VirtualActionListener listener){
		vActionListeners.remove(listener);
	}

	@Override
	public void addKeyUpHandler(Object handler) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
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
			String command = VirtualTextField.COMMAND_LABEL + this.getID() + BLOCK_ACTION_EVENT_FORWARDING_COMMAND + uniqueID + "," + block +")";
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
