package bus.uigen.widgets.gwt;

import java.util.Iterator;

import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class GWTTextFieldEventForwarder implements ValueChangeHandler<String> {

	GWTTextField component;
	
	public GWTTextFieldEventForwarder(GWTTextField c){
		component = c;
	}
	
	public void onValueChange(ValueChangeEvent<String> event) {
		VirtualActionEvent gen = GWTEventPackager.convert(event);
	
		Iterator<VirtualActionListener> listeners = component.getVirtualActionListeners().iterator();
		while(listeners.hasNext()){
			VirtualActionListener listener = listeners.next();
			if(!VirtualToolkit.isDistributed() || component.getOwner(listener).equals(VirtualToolkit.getUniqueID())){
				listener.actionPerformed(gen);
			}
		}
	}

}
