package bus.uigen.widgets.swing;

public class SwingSplitPaneFactory implements SplitPaneFactory, ContainerFactory {
	public VirtualSplitPane createSplitPane () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }