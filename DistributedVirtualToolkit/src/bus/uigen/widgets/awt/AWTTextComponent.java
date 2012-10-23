package bus.uigen.widgets.awt;

import java.awt.Event;
import java.awt.TextComponent;
import java.awt.TextField;

import javax.swing.text.PlainDocument;

import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;

public abstract class AWTTextComponent extends AWTComponent  {
	//JTextField getTextField();
	public AWTTextComponent (TextComponent theTextComponent) {
		super (theTextComponent);
		//getTextField() = theTextField;		
		
	}
	public AWTTextComponent() {
		
	}
	public TextComponent getTextComponent() {
		return (TextComponent) component;
	}
	
	public String getText() {
		return getTextComponent().getText();
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
		getTextComponent().setText(theText);
	}
	
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
	
	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getTextComponent().postEvent(event);
	}
	public boolean isEditable() {
		return getTextComponent().isEditable();
	}
	public void setEditable(boolean newVal) {
		getTextComponent().setEditable(newVal);
	}
	public static AWTTextField virtualTextField (TextField theTextField) {	
		return (AWTTextField) AWTComponent.virtualComponent(theTextField);		
			
	}
	
	

}
