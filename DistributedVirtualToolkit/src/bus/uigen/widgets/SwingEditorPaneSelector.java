package bus.uigen.widgets;public class SwingEditorPaneSelector  {	static TextAreaFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setTextAreaFactory (TextAreaFactory newVal) {
		factory = newVal;  }  public static  VirtualTextArea createTextArea(String text) {	  return factory.createTextArea(text);
	    }  public static  VirtualTextArea createTextArea(String text, int rows, int cols) {	  return factory.createTextArea(text, rows, cols);	    }  public static  VirtualTextArea createTextArea() {	  return factory.createTextArea();	    }  
}