package bus.uigen.widgets.swing;
public class SwingMenuItemFactory implements MenuItemFactory {
	public VirtualMenuItem createMenuItem (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }