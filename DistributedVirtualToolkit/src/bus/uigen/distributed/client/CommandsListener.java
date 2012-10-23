package bus.uigen.distributed.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.events.VirtualListener;

public interface CommandsListener extends Serializable{
	
	
	public void updateCommands(ArrayList<String> commands);
	public void updateListeners(Map<String, VirtualListener> vlisteners);
}
