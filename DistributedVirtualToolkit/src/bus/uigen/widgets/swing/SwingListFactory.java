package bus.uigen.widgets.swing;

public class SwingListFactory implements ListFactory  {
	public VirtualList createList () {
		Container panel = new JPanel();
		//panel.setBackground(Color.white);
		return panel;
	}
 }