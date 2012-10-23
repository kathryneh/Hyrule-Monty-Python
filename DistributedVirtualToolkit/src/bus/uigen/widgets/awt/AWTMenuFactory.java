package bus.uigen.widgets.awt;import bus.uigen.widgets.MenuFactory;import bus.uigen.widgets.VirtualMenu;
import java.awt.Menu;import java.util.Hashtable;
public class AWTMenuFactory implements MenuFactory {	static int id;
	public VirtualMenu createMenu (String text) {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createAWTMenu(text);
	}	/*	public VirtualMenu createMenu (Object icon) {				return createMenu((Icon) icon);	}	*/	public VirtualMenu createMenu () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createAWTMenu();	}	 static int getNewID() {		return id++;	}	public static AWTMenu createAWTMenu (String text) {		Menu menuItem = new Menu(text);		return virtualMenu(menuItem);		//return new Panel();		//return new JPanel();	}	/*	public static AnAWTMenu createAWTMenu (Icon icon) {		Menu menuItem = new Menu(icon);		return virtualMenu(menuItem);		//return new Panel();		//return new JPanel();	}	*/	public static AWTMenu createAWTMenu () {		Menu menuItem = new Menu();		return virtualMenu(menuItem);		//return new Panel();		//return new JPanel();	}	static transient Hashtable<Menu, AWTMenu> MenusToVirtualMenus = new Hashtable<Menu, AWTMenu>();		public static AWTMenu virtualMenu (Menu theMenu) {			if (theMenu == null) return null;			AWTMenu vc = MenusToVirtualMenus.get(theMenu);			if (vc == null) {								vc = new AWTMenu (theMenu);				MenusToVirtualMenus.put(theMenu, vc);						}			return vc;						}	  
 }
