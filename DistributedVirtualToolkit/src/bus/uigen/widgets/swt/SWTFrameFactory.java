package bus.uigen.widgets.swt;import org.eclipse.swt.widgets.Display;import org.eclipse.swt.widgets.Shell;import bus.uigen.widgets.FrameFactory;import bus.uigen.widgets.VirtualContainer;import bus.uigen.widgets.VirtualFrame;public class  SWTFrameFactory implements FrameFactory {	
	public VirtualFrame createFrame () {
		Display display = Display.getDefault();				Shell shell = new Shell (display);		//VirtualContainer container = new SWTShell ();		VirtualContainer container = SWTContainer.virtualContainer(shell);		//container.init(shell);
		//panel.setBackground(Color.white);
		VirtualFrame virtualFrame = SWTFrame.virtualFrame(display);		//virtualFrame.init(display);		virtualFrame.setContentPane(container);		shell.pack(); //is this necessary here?		return virtualFrame;		//return new Panel();
	}	public VirtualFrame createFrame (String title) {		return createFrame();		/*		Frame frame = new Frame(title);		//panel.setBackground(Color.white);		return SWTFrame.virtualFrame(frame);		//return new Panel();		 * */		 	}  
 }
