package bus.uigen.widgets.swt;
public class SWTMenuFactory implements MenuFactory {
	public VirtualMenu createMenu (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }