package bus.uigen.widgets.swing;

public class SwingRadioButtonFactory implements RadioButtonFactory {
	public VirtualRadioButton createRadioButton (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }