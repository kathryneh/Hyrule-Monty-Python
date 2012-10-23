package bus.uigen.widgets.awt;import java.awt.*;
import bus.uigen.widgets.PanelFactory;import bus.uigen.widgets.VirtualContainer;public class  AWTPanelFactory implements PanelFactory {	
	public VirtualContainer createPanel () {
		Container panel = new Panel();
		//panel.setBackground(Color.white);
		VirtualContainer toReturn = AWTContainer.virtualContainer(panel);		toReturn.init();		return toReturn;		//return new Panel();
	}  
 }
