package bus.uigen.widgets.swing;

import java.awt.Event;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTComponent;

public abstract class SwingTextComponent extends AWTComponent  {
	//JTextField getTextField();
	public SwingTextComponent (JTextComponent theTextComponent) {
		super (theTextComponent);
		//getTextField() = theTextField;		
		
	}
	public SwingTextComponent() {
		
	}
	public JTextComponent getTextComponent() {
		return (JTextComponent) component;
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
		System.out.println("Ending set text:   "+System.currentTimeMillis());
		
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
		getTextComponent().setDocument(d);
	}
	public void setDocument(Object d) {
		setDocument((PlainDocument) d);
	}
	
	public void postEvent(Event event) {
		getTextComponent().postEvent(event);
	}
	public boolean isEditable() {
		return getTextComponent().isEditable();
	}
	public void setEditable(boolean newVal) {
		getTextComponent().setEditable(newVal);
	}
	public static SwingTextField virtualTextField (JTextField theTextField) {	
		return (SwingTextField) AWTComponent.virtualComponent(theTextField);		
			
	}
	
	

}
