package bus.uigen.widgets;
public class ScrollPaneSelector  {	//static ScrollPaneFactory factory = new AWTScrollPaneFactory();	static ScrollPaneFactory factory;
	  public static void setScrollPaneFactory (ScrollPaneFactory newVal) {
		factory = newVal;  }  public static  VirtualScrollPane createScrollPane() {	  return factory.createScrollPane();
	    }  public static  VirtualScrollPane createScrollPane(VirtualComponent c) {	  return factory.createScrollPane(c);	    }
}