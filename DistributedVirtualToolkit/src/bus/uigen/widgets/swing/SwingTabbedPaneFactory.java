package bus.uigen.widgets.swing;import javax.swing.JTabbedPane;import bus.uigen.widgets.ContainerFactory;import bus.uigen.widgets.TabbedPaneFactory;import bus.uigen.widgets.VirtualContainer;import bus.uigen.widgets.VirtualTabbedPane;

public class SwingTabbedPaneFactory implements TabbedPaneFactory, ContainerFactory {	static int id;
	public VirtualTabbedPane createTabbedPane () {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJTabbedPane();
	}		 static int getNewID() {		return id++;	}	//public static JPanel createJPanel () {			public static VirtualTabbedPane createJTabbedPane () {		JTabbedPane panel = new JTabbedPane();				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualTabbedPane toReturn = SwingTabbedPane.virtualTabbedPane(panel);		toReturn.init();		return toReturn;		//return new Panel();	}			public VirtualContainer createContainer() {		return createJTabbedPane();	}  
 }
