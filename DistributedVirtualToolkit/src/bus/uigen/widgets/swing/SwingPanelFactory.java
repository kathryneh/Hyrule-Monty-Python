package bus.uigen.widgets.swing;

public class SwingPanelFactory implements PanelFactory, ContainerFactory {
	public VirtualContainer createPanel () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }