package bus.uigen.widgets;public class LabelSelector  {	static LabelFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setLabelFactory (LabelFactory newVal) {
		factory = newVal;  }    public static  VirtualLabel createLabel() {	  return factory.createLabel();	    }    public static  VirtualLabel createLabel(String text) {	  return factory.createLabel(text);
	    }  public static  VirtualLabel createLabel(Object icon) {	  return factory.createLabel(icon);	    }
}