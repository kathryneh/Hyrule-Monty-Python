package bus.uigen.widgets.swing;import javax.swing.JTextField;import bus.uigen.widgets.TextFieldFactory;import bus.uigen.widgets.VirtualTextField;

public class SwingTextFieldFactory implements TextFieldFactory {	static int id;
	public VirtualTextField createTextField (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJTextField(text);
	}	public VirtualTextField createTextField () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJTextField();	}		 static int getNewID() {		return id++;	}	public static VirtualTextField createJTextField (String text) {		JTextField textField = new JTextField(text);		SwingTextField toReturn = SwingTextField.virtualTextField(textField);				toReturn.init();		return toReturn;			}	public static VirtualTextField createJTextField () {		JTextField textField = new JTextField();		SwingTextField toReturn = SwingTextField.virtualTextField(textField);		toReturn.init();		return toReturn;	}	  
 }
