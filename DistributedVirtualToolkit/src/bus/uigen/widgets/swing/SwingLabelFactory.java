package bus.uigen.widgets.swing;
public class SwingLabelFactory implements LabelFactory {
	public VirtualLabel createLabel (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }