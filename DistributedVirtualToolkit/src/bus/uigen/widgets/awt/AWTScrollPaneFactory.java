package bus.uigen.widgets.awt;import bus.uigen.widgets.ScrollPaneFactory;import bus.uigen.widgets.VirtualComponent;import bus.uigen.widgets.VirtualScrollPane;import java.awt.*;
public class  AWTScrollPaneFactory implements ScrollPaneFactory {	
	public VirtualScrollPane createScrollPane () {
		ScrollPane scrollPane = new ScrollPane();
		//scrollPane.setBackground(Color.white);		//return new ScrollPane();				VirtualScrollPane toReturn = AWTScrollPane.virtualScrollPane(scrollPane);		toReturn.init();		return toReturn;
	}	public VirtualScrollPane createScrollPane (VirtualComponent c) {		ScrollPane scrollPane = new ScrollPane();		VirtualScrollPane retVal = AWTScrollPane.virtualScrollPane(scrollPane);		retVal.add(c);		retVal.init();		return retVal;		//scrollPane.add((Component)c.getPhysicalComponent()); 		//scrollPane.setBackground(Color.white);		//return AnAWTScrollPane.virtualScrollPane(scrollPane, c);				//return new JScrollPane();	}  
 }
