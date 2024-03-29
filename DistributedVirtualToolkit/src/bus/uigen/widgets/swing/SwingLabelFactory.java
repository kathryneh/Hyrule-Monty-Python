package bus.uigen.widgets.swing;import javax.swing.Icon;import javax.swing.JLabel;import bus.uigen.widgets.LabelFactory;import bus.uigen.widgets.VirtualLabel;
public class SwingLabelFactory implements LabelFactory {	static int id;		public VirtualLabel createLabel(){		return new SwingLabel();	}	
	public VirtualLabel createLabel (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJLabel(text);
	}	public VirtualLabel createLabel (Object icon) {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJLabel((Icon) icon);	}	 static int getNewID() {		return id++;	}	public static VirtualLabel createJLabel (String text) {		JLabel label = new JLabel(text);				VirtualLabel toReturn = SwingLabel.virtualLabel(label);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static VirtualLabel createJLabel (Icon icon) {		JLabel label = new JLabel(icon);		VirtualLabel toReturn = SwingLabel.virtualLabel(label);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
