package bus.uigen.widgets.swing;import javax.swing.JScrollPane;import bus.uigen.widgets.ScrollPaneFactory;import bus.uigen.widgets.VirtualComponent;import bus.uigen.widgets.VirtualScrollPane;

public class SwingScrollPaneFactory implements ScrollPaneFactory {	
	public VirtualScrollPane createScrollPane () {
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBackground(Color.white);		VirtualScrollPane toReturn = SwingScrollPane.virtualScrollPane(scrollPane);				toReturn.init();		return toReturn;		//return new JScrollPane();
	}	public VirtualScrollPane createScrollPane (VirtualComponent c) {		//JScrollPane scrollPane = new JScrollPane((Component) c.getPhysicalComponent());		JScrollPane scrollPane = new JScrollPane();		VirtualScrollPane retVal = SwingScrollPane.virtualScrollPane(scrollPane);		retVal.init();		retVal.add(c);		return retVal;		//scrollPane.setBackground(Color.white);		//return ASwingScrollPane.virtualScrollPane(scrollPane, c);							//return new JScrollPane();	}  
 }
