package bus.uigen.widgets;public class MenuSelector  {	//static MenuFactory factory = new AWTMenuFactory();	static MenuFactory factory;
	  public static void setMenuFactory (MenuFactory newVal) {
		factory = newVal;  }  public static  VirtualMenu createMenu(String text) {	  return factory.createMenu(text);
	    }  public static  VirtualMenu createMenu() {	  return factory.createMenu();	    }  /*  public static  VirtualMenu createMenu (Object icon) {	  return factory.createMenu(icon);	    }  */
}