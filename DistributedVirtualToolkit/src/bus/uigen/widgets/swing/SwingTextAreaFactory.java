package bus.uigen.widgets.swing;

public class SwingTextAreaFactory implements TextAreaFactory {
	public VirtualTextArea createTextArea (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }