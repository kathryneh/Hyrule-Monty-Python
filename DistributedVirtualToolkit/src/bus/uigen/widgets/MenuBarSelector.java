package bus.uigen.widgets;public class MenuBarSelector  {	//static MenuBarFactory factory = new AWTMenuBarFactory();	static MenuBarFactory factory;
	  public static void setMenuBarFactory (MenuBarFactory newVal) {
		factory = newVal;  }  public static  VirtualMenuBar createMenuBar(String text) {	  return factory.createMenuBar(text);
	    }  public static  VirtualMenuBar createMenuBar() {	  return factory.createMenuBar();	    }  /*  public static  VirtualMenuBar createMenuBar (Object icon) {	  return factory.createMenuBar(icon);	    }  */
}