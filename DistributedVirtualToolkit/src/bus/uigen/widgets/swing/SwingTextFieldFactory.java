package bus.uigen.widgets.swing;

public class SwingTextFieldFactory implements TextFieldFactory {
	public VirtualTextField createTextField (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }