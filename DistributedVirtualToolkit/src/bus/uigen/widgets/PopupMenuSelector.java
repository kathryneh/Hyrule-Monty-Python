package bus.uigen.widgets;public class PopupMenuSelector  {	//static MenuFactory factory = new AnAWTMenuFactory();	static PopupMenuFactory factory;	//static PopupMenuFactory factory = new AWTPopupMenuFactory();
	  public static void setMenuFactory (PopupMenuFactory newVal) {
		factory = newVal;  }  public static  VirtualPopupMenu createPopupMenu(String text) {	  return factory.createMenu(text);
	    }  public static  VirtualPopupMenu createPopupMenu() {	  return factory.createMenu();	    }  /*  public static  VirtualMenu createMenu (Object icon) {	  return factory.createMenu(icon);	    }  */
}