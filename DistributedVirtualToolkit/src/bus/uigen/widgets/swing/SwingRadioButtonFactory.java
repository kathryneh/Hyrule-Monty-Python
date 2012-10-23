package bus.uigen.widgets.swing;import javax.swing.JRadioButton;import bus.uigen.widgets.RadioButtonFactory;import bus.uigen.widgets.VirtualRadioButton;

public class SwingRadioButtonFactory implements RadioButtonFactory {	static int id;
	public VirtualRadioButton createRadioButton (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJRadioButton(text);
	}	public VirtualRadioButton createRadioButton () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJRadioButton();	}		 static int getNewID() {		return id++;	}	public static VirtualRadioButton createJRadioButton (String text) {		JRadioButton radioButton = new JRadioButton(text);		VirtualRadioButton toReturn = SwingRadioButton.virtualRadioButton(radioButton);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static VirtualRadioButton createJRadioButton () {		JRadioButton radioButton = new JRadioButton();		VirtualRadioButton toReturn = SwingRadioButton.virtualRadioButton(radioButton);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
