package bus.uigen.widgets.swt;
public class SWTMenuBarFactory implements MenuBarFactory {
	public VirtualMenuBar createMenuBar (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }