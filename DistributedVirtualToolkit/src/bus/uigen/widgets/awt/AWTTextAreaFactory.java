package bus.uigen.widgets.awt;

public class AWTTextAreaFactory implements TextAreaFactory {
	public VirtualTextArea createTextArea (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }