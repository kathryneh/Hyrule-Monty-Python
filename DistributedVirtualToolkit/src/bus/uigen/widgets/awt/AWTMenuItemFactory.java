package bus.uigen.widgets.awt;import bus.uigen.widgets.MenuItemFactory;import bus.uigen.widgets.VirtualMenuItem;
import java.awt.MenuItem;
public class AWTMenuItemFactory implements MenuItemFactory {	static int id;
	public VirtualMenuItem createMenuItem (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createAWTMenuItem(text);
	}	/*	public VirtualMenuItem createMenuItem (Object icon) {				return createMenuItem((Icon) icon);	}	*/	public VirtualMenuItem createMenuItem () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createAWTMenuItem();	}	 static int getNewID() {		return id++;	}	public static AWTMenuItem createAWTMenuItem (String text) {		MenuItem menuItem = new MenuItem(text);		return AWTMenuItem.virtualMenuItem(menuItem);		//return new Panel();		//return new JPanel();	}	/*	public static AnAWTMenuItem createAWTMenuItem (Icon icon) {		MenuItem menuItem = new MenuItem(icon);		return virtualMenuItem(menuItem);		//return new Panel();		//return new JPanel();	}	*/	public static AWTMenuItem createAWTMenuItem () {		MenuItem menuItem = new MenuItem();		return AWTMenuItem.virtualMenuItem(menuItem);		//return new Panel();		//return new JPanel();	}	  
 }
