package bus.uigen.widgets.swing;
//import java.awt.Menu;
public class SwingPopupMenuFactory implements PopupMenuFactory {
	public VirtualPopupMenu createMenu (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }