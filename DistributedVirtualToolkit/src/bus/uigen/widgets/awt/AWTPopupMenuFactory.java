package bus.uigen.widgets.awt;
//import java.awt.Menu;
public class AWTPopupMenuFactory implements PopupMenuFactory {
	public VirtualPopupMenu createMenu (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }