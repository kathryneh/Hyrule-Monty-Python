package bus.uigen.widgets.awt;import javax.swing.Icon;import bus.uigen.widgets.LabelFactory;import bus.uigen.widgets.VirtualLabel;
import java.awt.Label;
public class AWTLabelFactory implements LabelFactory {	static int id;		public VirtualLabel createLabel(){		return new AWTLabel();	}
	public VirtualLabel createLabel (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createAWTLabel(text);
	}	public VirtualLabel createLabel (Object icon) {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createAWTLabel((Icon) icon);	}	 static int getNewID() {		return id++;	}	public static VirtualLabel createAWTLabel (String text) {		Label label = new Label(text);				VirtualLabel toReturn = AWTLabel.virtualLabel(label);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static VirtualLabel createAWTLabel (Icon icon) {		Label label = new Label(icon.toString());		VirtualLabel toReturn = AWTLabel.virtualLabel(label);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
