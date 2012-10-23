package bus.uigen.widgets.awt;import bus.uigen.widgets.TextFieldFactory;import bus.uigen.widgets.VirtualTextField;
import java.awt.TextField;
public class AWTTextFieldFactory implements TextFieldFactory {	static int id;
	public VirtualTextField createTextField (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		//return createAWTTextField(text);		AWTTextField toReturn = new AWTTextField(text);		toReturn.init();				return toReturn;
	}	public VirtualTextField createTextField () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		//return createAWTTextField();		AWTTextField toReturn = new AWTTextField();		toReturn.init();				return toReturn;	}		 static int getNewID() {		return id++;	}	public static VirtualTextField createAWTTextField (String text) {		TextField textField = new TextField(text);		AWTTextField toReturn = AWTTextField.virtualTextField(textField);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static VirtualTextField createAWTTextField () {		TextField textField = new TextField();				AWTTextField toReturn = AWTTextField.virtualTextField(textField);		toReturn.init();				return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
