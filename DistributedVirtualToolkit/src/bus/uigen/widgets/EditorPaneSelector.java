package bus.uigen.widgets;public class EditorPaneSelector  {	static EditorPaneFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setEditorPaneFactory (EditorPaneFactory newVal) {
		factory = newVal;  }  public static  VirtualEditorPane createEditorPane(String text) {	  return factory.createEditorPane(text);
	    }    public static  VirtualEditorPane createEditorPane() {	  return factory.createEditorPane();	    }  
}