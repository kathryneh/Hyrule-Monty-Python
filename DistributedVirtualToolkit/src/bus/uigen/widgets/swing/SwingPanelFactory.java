package bus.uigen.widgets.swing;import javax.swing.JPanel;import bus.uigen.widgets.ContainerFactory;import bus.uigen.widgets.PanelFactory;import bus.uigen.widgets.VirtualContainer;import bus.uigen.widgets.awt.AWTContainer;

public class SwingPanelFactory implements PanelFactory, ContainerFactory {	static int id;
	public VirtualContainer createPanel () {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJPanel();
	}	 static int getNewID() {		return id++;	}	//public static JPanel createJPanel () {	public static VirtualContainer createJPanel () {		JPanel panel = new JPanel();				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualContainer toReturn =  SwingPanel.virtualContainer(panel);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public VirtualContainer createContainer() {		return createJPanel();	}  
 }
