package bus.uigen.widgets.swing;import javax.swing.JInternalFrame;import bus.uigen.widgets.InternalFrameFactory;import bus.uigen.widgets.VirtualFrame;import bus.uigen.widgets.VirtualInternalFrame;public class SwingInternalFrameFactory implements InternalFrameFactory {	
	public VirtualInternalFrame createInternalFrame () {
		JInternalFrame frame = new JInternalFrame();
		//panel.setBackground(Color.white);
		VirtualInternalFrame toReturn = SwingInternalFrame.virtualFrame(frame);		toReturn.init();		return toReturn;		//return new Panel();
	}	public VirtualInternalFrame createInternalFrame (String title) {		JInternalFrame frame = new JInternalFrame(title);		//panel.setBackground(Color.white);		VirtualInternalFrame toReturn = SwingInternalFrame.virtualFrame(frame);		toReturn.init();		return toReturn;		//return new Panel();	}	public VirtualInternalFrame createFrame () {		return createInternalFrame();	}				public VirtualFrame createFrame (String title) {		return createInternalFrame (title);	}  
 }
