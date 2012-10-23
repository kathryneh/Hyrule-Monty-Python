package bus.uigen.widgets;

import bus.uigen.distributed.client.CommandsListener;
import bus.uigen.widgets.events.VirtualListener;


public interface ProxyGWTServerEnd{

	public void setID(String userDefinedID);
	public String getID();
	public String getUniqueID();
	public void send(String command);
	public void sendListener(VirtualListener listener, String id);
	public void checkCommands();
	public void checkListeners();
	public void addCommandsListener(CommandsListener listener);

}
