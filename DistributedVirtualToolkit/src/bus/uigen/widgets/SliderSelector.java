package bus.uigen.widgets;public class SliderSelector  {	static SliderFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setSliderFactory (SliderFactory newVal) {
		factory = newVal;  }  public static  VirtualSlider createSlider(int val) {	  return factory.createSlider(val);
	    }  public static  VirtualSlider createSlider() {	  return factory.createSlider();	    }  
}