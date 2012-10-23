package bus.uigen.widgets.swt;

import bus.uigen.widgets.swt.Display;
import bus.uigen.widgets.swt.SWTToolkit;
import bus.uigen.widgets.universal.AUniversalWidget;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;

public class Shell extends Decorations {
	VirtualContainer shell; 
	public Shell(Display display) {
		shell = ((VirtualFrame) (AUniversalWidget.existingUniversalWidget(display.frame.getPhysicalComponent()))).getContentPane();
		shell.setParent((VirtualContainer) (display.frame)); //is this legal?
	}
	public void pack() {
		shell.pack();
	}
	public void open() {
		//((VirtualFrame) AUniversalWidget.existingUniversalWidget(d.frame.getPhysicalComponent())).setVisible(true);
		((VirtualFrame) AUniversalWidget.existingUniversalWidget(shell.getParent().getPhysicalComponent())).setVisible(true);
		//VirtualToolkit.start((VirtualFrame) AUniversalWidget.existingUniversalWidget(d.frame.getPhysicalComponent()));
		VirtualToolkit toolkit = new SWTToolkit();
		toolkit.start((VirtualFrame) AUniversalWidget.existingUniversalWidget(shell.getParent().getPhysicalComponent()));
	}
	public void setSize(int width, int height) {
		//((VirtualContainer) (shell.getPhysicalComponent())).setSize(width, height);
		shell.setSize(width, height);
	}
}
