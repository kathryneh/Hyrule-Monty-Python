package bus.uigen.widgets;public class ProgressBarSelector  {	static ProgressBarFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setProgressBarFactory (ProgressBarFactory newVal) {
		factory = newVal;  }  public static  VirtualProgressBar createProgressBar(int val) {	  return factory.createProgressBar(val);
	    }  public static  VirtualProgressBar createProgressBar(int val, int min, int max) {	  return factory.createProgressBar(val, min, max);	    }  public static  VirtualProgressBar createProgressBar() {	  return factory.createProgressBar();	    }  
}