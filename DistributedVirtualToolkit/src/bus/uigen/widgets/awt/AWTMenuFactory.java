package bus.uigen.widgets.awt;
import java.awt.Menu;
public class AWTMenuFactory implements MenuFactory {
	public VirtualMenu createMenu (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }