package bus.uigen.widgets.swing;

public class SwingTabbedPaneFactory implements TabbedPaneFactory, ContainerFactory {
	public VirtualTabbedPane createTabbedPane () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }