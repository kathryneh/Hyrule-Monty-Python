package bus.uigen.widgets;public class TabbedPaneSelector  {	static TabbedPaneFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setTabbedPaneFactory (TabbedPaneFactory newVal) {
		factory = newVal;  }  public static  VirtualTabbedPane createTabbedPane() {	  return factory.createTabbedPane();
	    }  
}