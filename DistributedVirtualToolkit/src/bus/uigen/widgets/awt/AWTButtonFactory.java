package bus.uigen.widgets.awt;import javax.swing.Icon;import bus.uigen.widgets.ButtonFactory;import bus.uigen.widgets.VirtualButton;import java.awt.Button;

public class AWTButtonFactory implements ButtonFactory {	static int id;
	public VirtualButton createButton (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJButton(text);
	}	public VirtualButton createButton (Object icon) {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJButton((Icon) icon);	}	public VirtualButton createButton () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJButton();	}	 static int getNewID() {		return id++;	}	public static AWTButton createJButton (String text) {		Button button = new Button(text);		AWTButton toReturn = AWTButton.virtualButton(button);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static AWTButton createJButton (Icon icon) {		Button button = new Button(icon.toString());		AWTButton toReturn = AWTButton.virtualButton(button);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static AWTButton createJButton () {		Button button = new Button();		AWTButton toReturn = AWTButton.virtualButton(button);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
