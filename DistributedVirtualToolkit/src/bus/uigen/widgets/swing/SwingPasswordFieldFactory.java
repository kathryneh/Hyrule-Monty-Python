package bus.uigen.widgets.swing;

public class SwingPasswordFieldFactory implements PasswordFieldFactory {
	public VirtualPasswordField createPasswordField (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }