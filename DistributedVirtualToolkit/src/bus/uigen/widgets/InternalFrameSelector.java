package bus.uigen.widgets;public class InternalFrameSelector  {	static InternalFrameFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setInternalFrameFactory (InternalFrameFactory newVal) {
		factory = newVal;  }  public static  VirtualInternalFrame createInternalFrame() {	  return factory.createInternalFrame();
	    }  public static  VirtualInternalFrame createInternalFrame(String title) {	  return factory.createInternalFrame(title);	    }
}