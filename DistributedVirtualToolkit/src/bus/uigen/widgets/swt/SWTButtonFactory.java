package bus.uigen.widgets.swt;

public class SWTButtonFactory implements ButtonFactory {
	public VirtualButton createButton (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }