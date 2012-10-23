package bus.uigen.widgets.swing;import javax.swing.JMenuItem;import bus.uigen.widgets.MenuItemFactory;import bus.uigen.widgets.VirtualMenuItem;
public class SwingMenuItemFactory implements MenuItemFactory {	static int id;
	public VirtualMenuItem createMenuItem (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createSwingMenuItem(text);
	}	/*	public VirtualMenuItem createMenuItem (Object icon) {				return createMenuItem((Icon) icon);	}	*/	public VirtualMenuItem createMenuItem () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createSwingMenuItem();	}	 static int getNewID() {		return id++;	}	public static SwingMenuItem createSwingMenuItem (String text) {		JMenuItem menuItem = new JMenuItem(text);		return SwingMenuItem.virtualMenuItem(menuItem);		//return new Panel();		//return new JPanel();	}	/*	public static ASwingMenuItem createSwingMenuItem (Icon icon) {		MenuItem menuItem = new MenuItem(icon);		return virtualMenuItem(menuItem);		//return new Panel();		//return new JPanel();	}	*/	public static SwingMenuItem createSwingMenuItem () {		JMenuItem menuItem = new JMenuItem();		return SwingMenuItem.virtualMenuItem(menuItem);		//return new Panel();		//return new JPanel();	}	  
 }
