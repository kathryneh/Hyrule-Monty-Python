package bus.uigen.widgets.swing;import javax.swing.JPasswordField;import bus.uigen.widgets.PasswordFieldFactory;import bus.uigen.widgets.VirtualPasswordField;

public class SwingPasswordFieldFactory implements PasswordFieldFactory {	static int id;
	public VirtualPasswordField createPasswordField (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJPasswordField(text);
	}	public VirtualPasswordField createPasswordField () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJPasswordField();	}		 static int getNewID() {		return id++;	}	public static VirtualPasswordField createJPasswordField (String text) {		JPasswordField textField = new JPasswordField(text);		VirtualPasswordField toReturn = SwingPasswordField.virtualPasswordField(textField);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static VirtualPasswordField createJPasswordField () {		JPasswordField textField = new JPasswordField();		VirtualPasswordField toReturn = SwingPasswordField.virtualPasswordField(textField);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
