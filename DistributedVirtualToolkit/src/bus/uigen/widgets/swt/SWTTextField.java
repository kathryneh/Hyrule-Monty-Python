package bus.uigen.widgets.swt;

import java.awt.Event;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.text.PlainDocument;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import bus.uigen.distributed.client.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.universal.AUniversalWidget;

public class SWTTextField extends SWTComponent implements VirtualTextField {

	Map<VirtualActionListener,String> vActionListeners = new HashMap<VirtualActionListener,String>();
	boolean blockActionEvents;
	
	String text="";
	//JTextField getTextField();
/*	public SWTTextField (Text theTextField) {
		super (theTextField);
		//getTextField() = theTextField;		
		
	}*/
	public SWTTextField (String theText) {
		text = theText;
		//getTextField().setText(theText); //object doesn't exist yet
	}
	public SWTTextField() {
		
	}
	
	public void init(){
		super.init();
	}
	
	public Set<VirtualActionListener> getVirtualActionListeners(){
		return vActionListeners.keySet();
	}
	
	public Text getTextField() {
		return (Text) component;
	}
	
	public int getColumns() {
		return 0;
		//return getTextField().getColumns();
	}
	public void setColumns (int theNumber) {
		//getTextField().setColumns(theNumber);
	}
		
	public void postActionEvent() {
		System.out.println("Post Event Not Defined for Text Field");
		//getTextField().postActionEvent();
	}
	//@Override
	public void addToParent(VirtualContainer theParent) {
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
		
		
		component = new Text ((Composite)theParent.getPhysicalComponent(), SWT.BORDER);
		
		init();
		addAllListeners();
		execSetText(text);
		//getTextField().setBounds(15,10,400,40);
		if ((xLocation!=-1)&&(yLocation!=-1)) getTextField().setLocation(xLocation,yLocation); //is there a better way to do this than with these flags?
		if ((width!=-1)&&(height!=-1)) getComponent().setSize(width,height);
		getTextField().setTextLimit(14); //there should be a setTextLimit method too
		AUniversalWidget.register(component, this);
		//addExistingChildren();
		//if ((width==-1)||(height==-1)) getComponent().pack(); //if dimensions aren't set, although this isn't default in SWT
		
	}
	public String getText() {
		return ((Text)component).getText();
	}
	public void setText (String theText) {
		execSetText(theText);
		if(VirtualToolkit.isDistributed()){
			String widgetID = this.getID();
			String uniqueID = VirtualToolkit.getUniqueID();
			VirtualToolkit.sendCommand(VirtualTextComponent.COMMAND_LABEL + widgetID +VirtualTextComponent.SET_TEXT_COMMAND + uniqueID + "," + theText +")");
		}
	}
	
	
	public void execSetText(String theText){
		//getTextComponent().setText(theText);
		//text = new Text((Composite) getParent(),SWT.BORDER);
		text = theText;
		if(getTextField()!=null){
			getTextField().getDisplay().asyncExec(new TextSetter(theText));
		}
		//getTextField().setText(theText);
		
	}
	
	class TextSetter implements Runnable{
		String text;
		
		public TextSetter(String text){
			this.text = text;
		}
		
		
		public void run() {
			getTextField().setText(text);
		}
		
	}
	
	/*public void setBounds (int x, int y, int width, int height) {
		int flags = 0;
		//getTextField().setBounds(x, y, width, height, flags); //non-public
		getTextField().setBounds(x, y, width, height);
	}*/
	public void addTextListener(Object listener) {
		
	}
	/*
	public void addFocusListener(Object listener) {
		getTextField().addFocusListener((FocusListener) listener);
		
	}
	*/
	/*
	public void addActionListener(Object listener) {
		addActionListener((ActionListener) listener);
		
	}	
	*/
	public void setDocument(PlainDocument d) {
		System.out.println("Set Document not defined for AWT Text Component");
		//getTextComponent().setDocument(d);
	}
	public void setDocument(Object d) {
		setDocument((PlainDocument) d);
	}
	
	public void postEvent(Event event) {
		//getTextComponent().postEvent(event);
	}
	public boolean isEditable() {
		//return getTextComponent().isEditable();
		return true;
	}
	public void setEditable(boolean newVal) {
		//getTextComponent().setEditable(newVal);
	}
	public static SWTTextField virtualTextField (Text theTextField) {	
		return (SWTTextField) SWTComponent.virtualComponent(theTextField);		
			
	}
	
	public void addAllListeners(){
		super.addAllListeners();
		
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
	
	
	public void removeActionListener(VirtualActionListener listener){
		vActionListeners.remove(listener);
	}
	
	
	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
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
