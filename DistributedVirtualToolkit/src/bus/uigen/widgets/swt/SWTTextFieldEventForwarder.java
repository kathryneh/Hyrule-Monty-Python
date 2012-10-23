package bus.uigen.widgets.swt;

import java.util.Iterator;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SWTTextFieldEventForwarder implements ModifyListener {
	SWTTextField component;
	
	public SWTTextFieldEventForwarder(SWTTextField t){
		component = t;
	}
	
	public void modifyText(ModifyEvent event) {
		VirtualActionEvent gen = SWTEventPackager.convert(event);
	
		Iterator<VirtualActionListener> listeners = component.getVirtualActionListeners().iterator();
		while(listeners.hasNext()){
			VirtualActionListener listener = listeners.next();
			if(!VirtualToolkit.isDistributed() || component.getOwner(listener).equals(VirtualToolkit.getUniqueID())){
				listener.actionPerformed(gen);
			}
		}
	}

}
