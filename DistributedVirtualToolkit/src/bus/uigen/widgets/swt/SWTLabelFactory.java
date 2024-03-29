package bus.uigen.widgets.swt;import javax.swing.Icon;import bus.uigen.widgets.LabelFactory;import bus.uigen.widgets.VirtualLabel;

public class SWTLabelFactory implements LabelFactory {	static int id;
	public VirtualLabel createLabel (String text) {				return createSWTLabel(text);
	}	public VirtualLabel createLabel (Object icon) {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createSWTLabel((Icon) icon);	}	 static int getNewID() {		return id++;	}	 	public VirtualLabel createLabel(){		return new SWTLabel();	}	 	public static VirtualLabel createSWTLabel (String text) {		////JLabel label = new JLabel(text);				//return SWTLabel.virtualLabel(label);		return new SWTLabel(text);			}	public static VirtualLabel createSWTLabel (Icon icon) {		//return SWTLabel.virtualLabel(icon);		return new SWTLabel(icon);			}	  
 }
