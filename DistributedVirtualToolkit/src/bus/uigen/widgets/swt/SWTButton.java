package bus.uigen.widgets.swt;

import java.awt.Event;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.Icon;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import bus.uigen.distributed.client.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.universal.AUniversalWidget;

public class SWTButton extends SWTComponent  implements VirtualButton {
	//AbstractButton getButton();
	String text;
	
	SWTButtonEventForwarder forwarder = new SWTButtonEventForwarder(this);
	
	Map<VirtualActionListener, String> vActionListeners = new HashMap<VirtualActionListener, String>();
	boolean blockActionEvents;
	
	public SWTButton (Button theButton) {
		super (theButton);
		//getButton() = theButton;	
		
	}
	public SWTButton (String theText) {
		text = theText;
	}
	
	Button getButton() { //getLabel/TextField are public, but not getButton
		return (Button) component;
	}
	
	public String getLabel() {
		return null;
	}
	
	public SWTButton() {
		
	}
	
	public void init(){
		super.init();
		getButton().addSelectionListener(forwarder);
	}
	
	public void setActionCommand (String command) {
		//getButton().setActionCommand(command);
	}
	public String getText() {
		return getButton().getText();
	}
	public void setText (String theText) {
		text = theText;
		if(getButton() != null){
			getButton().setText(theText);
		}
	}
	public void setIcon (Object theIcon) {
		setIcon( (Icon)  theIcon);
	}
	public void setIcon (Icon theIcon) {
		//getButton().setLabel( theIcon.toString());
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
	public void postEvent(Event event) {
		//getButton().postEvent(event);
	}
	public void setMargin(Object margin) {
		setMargin((Insets) margin);
	}
	public static SWTButton virtualButton (Button theButton) {	
		return (SWTButton) SWTComponent.virtualComponent(theButton);		
			
	}

	//@Override
	public void addToParent (VirtualContainer theParent) {		
	
		if(theParent==null){
			throw new IllegalArgumentException("Argument cannot be null");
		}else{
			if(!(theParent instanceof SWTContainer)){
				throw new IllegalArgumentException("Argument must be of SWT type"); 
			}else{
				if(theParent.getPhysicalComponent()==null){
					throw new IllegalArgumentException("Cannot add to an unitialized parent");
				}
			}
		}
		
		component = new Button ((Composite)theParent.getPhysicalComponent(), SWT.PUSH);
		if(text!=null){
			getButton().setText(text);
		}
		
		//getButton().setLocation(10,30);
		//getButton().setSize(5,5);
		//getButton().pack();
		
		init();
		addAllListeners();
		getComponent().setLocation(xLocation,yLocation);
		getComponent().setSize(width,height);
		AUniversalWidget.register(component, this);
		
		//getButton().pack();
		//component.addToParent(theParent);
		
		if ((width==-1)||(height==-1)) getComponent().pack(); //if dimensions aren't set
		else if (toPack) getComponent().pack();
		
		theParent.layout();
		
	}
	//@Override
	public void pack() {
		// TODO Auto-generated method stub
		toPack = true;
		super.pack();
	}
	
	public void addAllListeners(){
		super.addAllListeners();
		
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
	
	public String getOwner(VirtualActionListener listener){
		return vActionListeners.get(listener);
	}
	
	public Set<VirtualActionListener> getVirtualActionListeners(){
		return vActionListeners.keySet();
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
