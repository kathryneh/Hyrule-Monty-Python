package bus.uigen.widgets.swing;

public class SwingDesktopPaneFactory implements DesktopPaneFactory, ContainerFactory {
	public VirtualDesktopPane createDesktopPane () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }