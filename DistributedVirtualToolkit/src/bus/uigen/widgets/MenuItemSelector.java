package bus.uigen.widgets;public class MenuItemSelector  {	//static MenuItemFactory factory = new AnAWTMenuItemFactory();	static MenuItemFactory factory;	//static MenuItemFactory factory = new AWTMenuItemFactory();	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setMenuItemFactory (MenuItemFactory newVal) {
		factory = newVal;  }  public static  VirtualMenuItem createMenuItem(String text) {	  return factory.createMenuItem(text);
	    }  public static  VirtualMenuItem createMenuItem() {	  return factory.createMenuItem();	    }  /*  public static  VirtualMenuItem createMenuItem (Object icon) {	  return factory.createMenuItem(icon);	    }  */
}