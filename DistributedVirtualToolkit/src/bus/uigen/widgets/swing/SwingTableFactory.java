package bus.uigen.widgets.swing;

public class SwingTableFactory implements TableFactory  {
	public VirtualTable createTable () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }