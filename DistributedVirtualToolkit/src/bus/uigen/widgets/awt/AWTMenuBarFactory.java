package bus.uigen.widgets.awt;
import java.awt.MenuBar;
public class AWTMenuBarFactory implements MenuBarFactory {
	public VirtualMenuBar createMenuBar (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }