package bus.uigen.widgets.awt;
import java.awt.MenuItem;
public class AWTMenuItemFactory implements MenuItemFactory {
	public VirtualMenuItem createMenuItem (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }