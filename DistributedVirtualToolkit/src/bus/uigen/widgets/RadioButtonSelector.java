package bus.uigen.widgets;public class RadioButtonSelector  {	static RadioButtonFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setRadioButtonFactory (RadioButtonFactory newVal) {
		factory = newVal;  }  public static  VirtualRadioButton createRadioButton(String text) {	  return factory.createRadioButton(text);
	    }  public static  VirtualRadioButton createRadioButton() {	  return factory.createRadioButton();	    }  
}