package bus.uigen.widgets.awt;
import java.awt.Label;
public class AWTLabelFactory implements LabelFactory {
	public VirtualLabel createLabel (String text) {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }