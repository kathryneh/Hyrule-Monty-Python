package bus.uigen.widgets.events;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;


public interface VirtualActionListener extends VirtualListener{
	
	public void actionPerformed(VirtualActionEvent e);
}
