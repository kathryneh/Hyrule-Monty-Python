package bus.uigen.widgets.swt;import bus.uigen.widgets.MenuItemFactory;import bus.uigen.widgets.VirtualMenuItem;
public class SWTMenuItemFactory implements MenuItemFactory {	static int id;
	public VirtualMenuItem createMenuItem (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createSWTMenuItem(text);
	}	/*	public VirtualMenuItem createMenuItem (Object icon) {				return createMenuItem((Icon) icon);	}	*/	public VirtualMenuItem createMenuItem () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createSWTMenuItem();	}	 static int getNewID() {		return id++;	}	public static SWTMenuItem createSWTMenuItem (String text) {		//MenuItem menuItem = new MenuItem(text);		//return SWTMenuItem.virtualMenuItem(menuItem);		return new SWTMenuItem(text);		//return new Panel();		//return new JPanel();	}	/*	public static AnAWTMenuItem createAWTMenuItem (Icon icon) {		MenuItem menuItem = new MenuItem(icon);		return virtualMenuItem(menuItem);		//return new Panel();		//return new JPanel();	}	*/	public static SWTMenuItem createSWTMenuItem () {		//MenuItem menuItem = new MenuItem();		//return SWTMenuItem.virtualMenuItem(menuItem);		return new SWTMenuItem();		//return new Panel();		//return new JPanel();	}	  
 }
