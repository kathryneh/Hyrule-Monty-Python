package bus.uigen.distributed.nongwt;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.distributed.client.CommandsListener;
import bus.uigen.distributed.server.GWTServerEndImpl;
import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.events.VirtualListener;

public class NonGwtProxyGWTServerEnd implements ProxyGWTServerEnd, CommandsListener{
	GWTServerEndImpl impl;
	ArrayList<CommandsListener> listeners = new ArrayList<CommandsListener>();
	
	public NonGwtProxyGWTServerEnd(String userDefinedID){//GWTServerEndImpl impl){
		this.impl = new GWTServerEndImpl();
		impl.setID(userDefinedID);
		impl.addCommandsListener(this);
	}
	
	public void sendListener(VirtualListener listener, String id){
		impl.sendListener(listener, id);
	}

	public void send(String command) {
		impl.send(command);
	}

	public void setID(String userDefinedID) {
		impl.setID(userDefinedID);
	}
	
	public void updateCommands(ArrayList<String> commands){
		
		if(commands != null ){
						
			for(int i=0; i<listeners.size(); i++){
				listeners.get(i).updateCommands(commands);
			}
		}
		
	}
	
	public void updateListeners(Map<String, VirtualListener> vlisteners){
		
		if(listeners != null ){
						
			for(int i=0; i<listeners.size(); i++){
				listeners.get(i).updateListeners(vlisteners);
			}
		}
		
	}

	public void checkCommands() {
		ArrayList<String> commands = impl.getCommands();
		if(commands != null && commands.size() > 0){
			updateCommands(commands);
		}
		
	}
	
	public void checkListeners() {
		Map<String, VirtualListener> vlisteners = impl.getListeners();
		if(vlisteners != null && vlisteners.size() > 0){
			updateListeners(vlisteners);
		}
	}

	public void addCommandsListener(CommandsListener listener) {
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public String getUniqueID(){
		return impl.getUniqueID();
	}
	
	public String getID(){
		return impl.getID();
	}

}
