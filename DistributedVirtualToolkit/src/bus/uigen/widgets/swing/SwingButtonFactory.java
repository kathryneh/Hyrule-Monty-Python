package bus.uigen.widgets.swing;

public class SwingButtonFactory implements ButtonFactory {
	public VirtualButton createButton (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }