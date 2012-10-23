package bus.uigen.widgets.gwt;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import bus.uigen.distributed.client.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;



public class GWTButton extends GWTComponent implements VirtualButton{
	
	Map<VirtualActionListener,String> vActionListeners = new HashMap<VirtualActionListener,String>();
	Vector<VirtualMouseMoveListener> vMouseMoveListeners = new Vector<VirtualMouseMoveListener>();
	
	boolean blockActionEvents = false;
	
	public GWTButton(){
		super(new Button());
	}
	
	public GWTButton(String html){
		super(new Button(html));
	}

	public GWTButton(Button b){
		super(b);
	}
	
	public void init(){
		GWTButtonEventForwarder forwarder = new GWTButtonEventForwarder(this);
		getButton().addClickHandler(forwarder);
	}
	
	public Vector<VirtualMouseMoveListener> getVirtualMouseMoveListeners(){
		return vMouseMoveListeners;
	}
	
	public Set<VirtualActionListener> getVirtualActionListeners(){
		return vActionListeners.keySet();
	}
	
	public String getOwner(VirtualActionListener listener){
		return vActionListeners.get(listener);
	}
	
	public Button getButton(){
		return (Button) component;
	}
	
	public void setEnabled(boolean enabled){
		getButton().setEnabled(enabled);
	}
	
	public void setFocus(boolean focus){
		getButton().setFocus(focus);
	}
	

	public void setHorizontalAlignment(int x) {
		/*if(getButton().getParent() instanceof HasHorizontalAlignment){
			if(x == SwingConstants.LEFT){
				((HasHorizontalAlignment) getButton().getParent()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			}else if(x == SwingConstants.RIGHT){
				((HasHorizontalAlignment) getButton().getParent()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
			}else if(x == SwingConstants.CENTER){
				((HasHorizontalAlignment) getButton().getParent()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			}else{
				((HasHorizontalAlignment) getButton().getParent()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_DEFAULT);
			}
		}*/
	}
	
	public void setVerticalAlignment(int alignment) {
		/*if(getButton().getParent() instanceof HasVerticalAlignment){
			if(alignment == SwingConstants.BOTTOM){
				((HasVerticalAlignment) getButton().getParent()).setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
			}else if(alignment == SwingConstants.CENTER){
				((HasVerticalAlignment) getButton().getParent()).setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			}else if(alignment == SwingConstants.TOP){
				((HasVerticalAlignment) getButton().getParent()).setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
			}else{
				((HasVerticalAlignment) getButton().getParent()).setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			}
		}*/
	}
	
	public Element getElement(){
		return getButton().getElement();
	}

	public String getLabel() {
		return getButton().getText();
	}

	public String getText() {
		return getButton().getText();
	}
	
	public void setText(String text) {
		getButton().setText(text);
	}
	
	public void addStyleName(String style){
		getButton().addStyleName(style);
	}
	
	public void addClickHandler(ClickHandler handler){
		getButton().addClickHandler(handler);
	}
	

	public void addClickHandler(Object handler) {
		if(handler instanceof ClickHandler){
			getButton().addClickHandler((ClickHandler)handler);
		}
		
	}

	@Override
	public void setActionCommand(String command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMargin(Object margin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setIcon(Object icon) {
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
	
	@Override
	public void removeActionListener(VirtualActionListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	public void addMouseMoveListener(VirtualMouseMoveListener listener){
		vMouseMoveListeners.add(listener);
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
			while (uniqueID == null){uniqueID = VirtualToolkit.getUniqueID();}
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