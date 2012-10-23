package bus.uigen.widgets.gwt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import bus.uigen.distributed.client.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.TextBox;

public class GWTTextField extends GWTComponent implements VirtualTextField{
	
	Map<VirtualActionListener,String> vActionListeners = new HashMap<VirtualActionListener,String>();
	boolean blockActionEvents;
	
	public GWTTextField(){
		super(new TextBox());
	}
	
	public GWTTextField(String text){
		super(new TextBox());
		getTextBox().setText(text);
	}
	
	public GWTTextField(TextBox t){
		super(t);
	}
	
	public void init(){
		getTextBox().addValueChangeHandler(new GWTTextFieldEventForwarder(this));
	}
	
	public Set<VirtualActionListener> getVirtualActionListeners(){
		return vActionListeners.keySet();
	}
	
	public TextBox getTextBox(){
		return (TextBox) component;
	}
	
	
	public void setFocus(boolean focused){
		getTextBox().setFocus(focused);
	}
	
	public void selectAll(){
		getTextBox().selectAll();
	}
	
	public void addKeyUpHandler(KeyUpHandler handler){
		getTextBox().addKeyUpHandler(handler);
	}


	public String getText() {
		return getTextBox().getText();
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void postActionEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColumns(int theNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTextListener(Object listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEditable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDocument(Object d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEditable(boolean newVal) {
		// TODO Auto-generated method stub
		
	}

	public void setText(String theText){
		execSetText(theText);
		if(VirtualToolkit.isDistributed()){
			String widgetID = this.getID();
			String uniqueID = VirtualToolkit.getUniqueID();
			while (uniqueID == null){uniqueID = VirtualToolkit.getUniqueID();}
			VirtualToolkit.sendCommand(VirtualTextComponent.COMMAND_LABEL + widgetID +VirtualTextComponent.SET_TEXT_COMMAND + uniqueID + "," + theText +")");
		}
	}
	
	public void execSetText(String theText) {
		getTextBox().setText(theText);	

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addKeyUpHandler(Object handler) {
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
	
	public String getOwner(VirtualActionListener listener){
		return vActionListeners.get(listener);
	}

	@Override
	public void removeActionListener(VirtualActionListener listener) {
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
			while (uniqueID == null){uniqueID = VirtualToolkit.getUniqueID();}
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