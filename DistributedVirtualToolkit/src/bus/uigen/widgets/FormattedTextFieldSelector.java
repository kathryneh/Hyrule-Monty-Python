package bus.uigen.widgets;public class FormattedTextFieldSelector  {	static FormattedTextFieldFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setFormattedTextFieldFactory (FormattedTextFieldFactory newVal) {
		factory = newVal;  }  public static  VirtualFormattedTextField createFormattedTextField(Object valueOrFormatterOrFactory) {	  return factory.createFormattedTextField(valueOrFormatterOrFactory);
	    }  public static  VirtualFormattedTextField createFormattedTextField() {	  return factory.createFormattedTextField();	    }    public  VirtualFormattedTextField createFormattedTextField(Object factory, Object currentValue) {	  return FormattedTextFieldSelector.factory.createFormattedTextField(factory, currentValue);  }  
}