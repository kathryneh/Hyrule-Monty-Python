package bus.uigen.widgets;public class ToolBarSelector  {	static ToolBarFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setToolBarFactory (ToolBarFactory newVal) {
		factory = newVal;  }  public static  VirtualToolBar createToolBar() {	  return factory.createToolBar();
	    }  public static  VirtualToolBar createToolBar(int direction) {	  return factory.createToolBar(direction);	    }
}