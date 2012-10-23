package bus.uigen.distributed.client;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.user.client.rpc.RemoteService;


public interface GWTServerEnd extends RemoteService{

	public void setID(String userDefinedID);
	public String getID();
	public String getUniqueID();
	
	public void send(String command);
	public void sendListener(VirtualListener listener, String id);
	
	public ArrayList<String> getCommands();
	public Map<String, VirtualListener> getListeners();

}
