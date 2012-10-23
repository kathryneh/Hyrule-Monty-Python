package bus.uigen.widgets.swt;

import java.awt.Event;
import java.awt.TextComponent;

import javax.swing.text.PlainDocument;

import org.eclipse.swt.widgets.Text;

public abstract class SWTTextComponent extends SWTComponent  {
	//JTextField getTextField();
	public SWTTextComponent (Text theTextComponent) { //ok to use Text instead of TextComponent here? takes Control
		super (theTextComponent);
		//getTextField() = theTextField;		
		
	}
	public SWTTextComponent() {
		
	}
	
	public void init(){
		super.init();
	}
	public TextComponent getTextComponent() {
		return (TextComponent) component;
	}
	
	public String getText() {
		return getTextComponent().getText();
	}
	public void setText (String theText) {
		getTextComponent().setText(theText);
		//Text text = new Text((Composite) getParent(),SWT.BORDER);
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
	
	public void postEvent(Event event) {
		getTextComponent().postEvent(event);
	}
	public boolean isEditable() {
		return getTextComponent().isEditable();
	}
	public void setEditable(boolean newVal) {
		getTextComponent().setEditable(newVal);
	}
	public static SWTTextField virtualTextField (Text theTextField) {	
		return (SWTTextField) SWTComponent.virtualComponent(theTextField);		
			
	}
	
	

}
