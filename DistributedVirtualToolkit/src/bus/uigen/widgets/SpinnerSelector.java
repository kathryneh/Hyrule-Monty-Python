package bus.uigen.widgets;public class SpinnerSelector  {	static SpinnerFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setSpinnerFactory (SpinnerFactory newVal) {
		factory = newVal;  }  public static  VirtualSpinner createSpinner() {	  return factory.createSpinner();
	    }  public static  VirtualSpinner createSpinner(Object model) {	  return factory.createSpinner(model);	    }
}