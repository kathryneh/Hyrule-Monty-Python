package bus.uigen.widgets;public class SplitPaneSelector  {	static SplitPaneFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setSplitPaneFactory (SplitPaneFactory newVal) {
		factory = newVal;  }  public static  VirtualSplitPane createSplitPane() {	  return factory.createSplitPane();
	    }  public static  VirtualSplitPane createSplitPane(int dir, VirtualComponent comp1, VirtualComponent comp2) {	  return factory.createSplitPane(dir, comp1, comp2);	    }
}