package bus.uigen.widgets.swt;
public class SWTMenuItemFactory implements MenuItemFactory {
	public VirtualMenuItem createMenuItem (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }