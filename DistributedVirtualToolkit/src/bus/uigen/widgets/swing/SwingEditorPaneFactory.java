package bus.uigen.widgets.swing;import javax.swing.JEditorPane;import bus.uigen.widgets.EditorPaneFactory;import bus.uigen.widgets.VirtualEditorPane;import bus.uigen.widgets.swing.SwingEditorPane;

public class SwingEditorPaneFactory implements EditorPaneFactory {	static int id;
	public VirtualEditorPane createEditorPane (String text) {				return createJEditorPane(text);
	}	public VirtualEditorPane createEditorPane () {				return createJEditorPane();	}		 static int getNewID() {		return id++;	}	public static VirtualEditorPane createJEditorPane (String text) {		try {		JEditorPane textArea = new JEditorPane(text);		VirtualEditorPane toReturn = SwingEditorPane.virtualEditorPane(textArea);		toReturn.init();		return toReturn;		} catch (Exception e) {			e.printStackTrace();			return null;		}			}		public static VirtualEditorPane createJEditorPane () {		JEditorPane textArea = new JEditorPane();		VirtualEditorPane toReturn = SwingEditorPane.virtualEditorPane(textArea);		toReturn.init();		return toReturn;	}		  
 }
