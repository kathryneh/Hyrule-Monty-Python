package bus.uigen.widgets;public class CheckBoxSelector  {	static CheckBoxFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setCheckBoxFactory (CheckBoxFactory newVal) {
		factory = newVal;  }    public static  VirtualCheckBox createCheckBox() {	  return factory.createCheckBox();	    }  
}