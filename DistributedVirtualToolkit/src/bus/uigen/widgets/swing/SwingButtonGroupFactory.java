package bus.uigen.widgets.swing;import javax.swing.ButtonGroup;import bus.uigen.widgets.ButtonGroupFactory;import bus.uigen.widgets.VirtualButtonGroup;
public class SwingButtonGroupFactory implements ButtonGroupFactory {	static int id;
	public VirtualButtonGroup createButtonGroup () {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createSwingButtonGroup();
	}			 static int getNewID() {		return id++;	}		public static VirtualButtonGroup createSwingButtonGroup () {		ButtonGroup ButtonGroup = new ButtonGroup();		return SwingButtonGroup.virtualButtonGroup(ButtonGroup);		//return new Panel();		//return new JPanel();	}	  
 }
