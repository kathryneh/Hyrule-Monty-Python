package bus.uigen.widgets.swing;

public class SwingToolBarFactory implements ToolBarFactory {
	public VirtualToolBar createToolBar () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }