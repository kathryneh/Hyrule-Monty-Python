package bus.uigen.widgets;public class PasswordFieldSelector  {	static PasswordFieldFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setPasswordFieldFactory (PasswordFieldFactory newVal) {
		factory = newVal;  }  public static  VirtualPasswordField createPasswordField(String text) {	  return factory.createPasswordField(text);
	    }  public static  VirtualPasswordField createPasswordField() {	  return factory.createPasswordField();	    }  
}