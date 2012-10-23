package bus.uigen.widgets.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class AWTTextFieldEventForwarder implements ActionListener {
	AWTTextField component;
	
	public AWTTextFieldEventForwarder(AWTTextField t){
		component = t;
	}
	
	
	public void actionPerformed(ActionEvent event) {
		VirtualActionEvent gen = AWTEventPackager.convert(event);
	
		Iterator<VirtualActionListener> listeners = component.getVirtualActionListeners().iterator();
		while(listeners.hasNext()){
			VirtualActionListener listener = listeners.next();
			if(!VirtualToolkit.isDistributed() || component.getOwner(listener).equals(VirtualToolkit.getUniqueID())){
				listener.actionPerformed(gen);
			}
		}
	}

}
