package bus.uigen.widgets;public class DesktopPaneSelector  {	static DesktopPaneFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setDesktopPaneFactory (DesktopPaneFactory newVal) {
		factory = newVal;  }  public static  VirtualDesktopPane createDesktopPane() {	  return factory.createDesktopPane();
	    }  
}