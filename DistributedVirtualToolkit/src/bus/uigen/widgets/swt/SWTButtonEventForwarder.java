package bus.uigen.widgets.swt;

import java.util.Iterator;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SWTButtonEventForwarder implements SelectionListener {
	SWTButton component;
	
	public SWTButtonEventForwarder(SWTButton b){
		component = b;
	}
	
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void widgetSelected(SelectionEvent event) {
		VirtualActionEvent virtualEvent = SWTEventPackager.convert(event);
		Iterator<VirtualActionListener> listeners =component.getVirtualActionListeners().iterator();
		while(listeners.hasNext()){
			VirtualActionListener listener = listeners.next();
			if(!VirtualToolkit.isDistributed() || component.getOwner(listener).equals(VirtualToolkit.getUniqueID())){
				listener.actionPerformed(virtualEvent);
			}
		}
	}

}
