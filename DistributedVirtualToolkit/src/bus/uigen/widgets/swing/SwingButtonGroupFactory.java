package bus.uigen.widgets.swing;
public class SwingButtonGroupFactory implements ButtonGroupFactory {
	public VirtualButtonGroup createButtonGroup () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }