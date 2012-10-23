package puretoolkit.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class MethodAlerter extends Shell{
	
	public MethodAlerter(Display display){
		super(display);
	}
	
	public void pack(){
		System.out.println("pack called");
		super.pack();
	}
	

	public void redraw(){
		System.out.println("redraw called");
		super.redraw();
	}
}
