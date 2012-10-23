package bus.uigen.widgets.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SwingTextFieldEventForwarder implements ActionListener {
	SwingTextField component;
	
	public SwingTextFieldEventForwarder(SwingTextField f){
		component = f;
	}
	
	public void actionPerformed(ActionEvent event) {
		VirtualActionEvent gen = SwingEventPackager.convert(event);
	
		Iterator<VirtualActionListener> listeners = component.getVirtualActionListeners().iterator();
		while(listeners.hasNext()){
			VirtualActionListener listener = listeners.next();
			if(!VirtualToolkit.isDistributed() || component.getOwner(listener).equals(VirtualToolkit.getUniqueID())){
				listener.actionPerformed(gen);
			}
		}
	}

}
