package bus.uigen.widgets.awt;
import java.awt.TextField;
public class AWTTextFieldFactory implements TextFieldFactory {
	public VirtualTextField createTextField (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }