package bus.uigen.widgets.awt;

public class AWTButtonFactory implements ButtonFactory {
	public VirtualButton createButton (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }