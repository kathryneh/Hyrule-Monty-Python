package bus.uigen.widgets.swing;
public class SwingMenuFactory implements MenuFactory {
	public VirtualMenu createMenu (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }