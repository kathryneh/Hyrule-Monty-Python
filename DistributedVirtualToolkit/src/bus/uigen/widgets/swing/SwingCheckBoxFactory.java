package bus.uigen.widgets.swing;import javax.swing.JCheckBox;import bus.uigen.widgets.CheckBoxFactory;import bus.uigen.widgets.VirtualCheckBox;

public class SwingCheckBoxFactory implements CheckBoxFactory {	static int id;
			public VirtualCheckBox createCheckBox () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJCheckBox();	}	 static int getNewID() {		return id++;	}			public static SwingCheckBox createJCheckBox () {		JCheckBox slider = new JCheckBox();		SwingCheckBox toReturn = SwingCheckBox.virtualCheckBox(slider);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
