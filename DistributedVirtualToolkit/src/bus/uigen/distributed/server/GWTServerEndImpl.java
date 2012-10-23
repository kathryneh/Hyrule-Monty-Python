package bus.uigen.distributed.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.distributed.client.CommandsListener;
import bus.uigen.distributed.client.GWTServerEnd;
import bus.uigen.distributed.nongwt.AnRmiClientEnd;
import bus.uigen.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GWTServerEndImpl extends RemoteServiceServlet implements GWTServerEnd, CommandsListener {
	
	ArrayList<String> commands;
	ArrayList<CommandsListener> listeners = new ArrayList<CommandsListener>();
	Map<String, VirtualListener> vlisteners;

	RmiClientEnd rmiClient;
	
	public GWTServerEndImpl(){
		
		RmiServerEnd rmiServerEnd = RegistrarStarter.getRegistrar();
		if(rmiServerEnd == null){
			RegistrarStarter starter = new RegistrarStarter();
			starter.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try{
			rmiClient = new AnRmiClientEnd();
			rmiClient.addCommandsListener(this);
		}catch(RemoteException e){
			throw new RuntimeException(e.getMessage());
		}		
	}
	
	public void setID(String userDefinedID){
		
		try {
			rmiClient.setID(userDefinedID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String command) {
		try {
			//System.out.println("Receive:"+ System.currentTimeMillis());
			rmiClient.send(command);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void sendListener(VirtualListener listener, String id) {
		try {
			rmiClient.sendListener(listener, id);;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void addCommandsListener(CommandsListener listener){
		listeners.add(listener);
	}
	
	public void updateCommands(ArrayList<String> commands){
		if(commands != null && (this.commands == null || this.commands.size() <= commands.size()) ){
			this.commands = commands;
			
			for(int i=0; i<listeners.size(); i++){
				listeners.get(i).updateCommands(commands);
			}
		}
	}
	
	public void updateListeners(Map<String, VirtualListener> vlisteners){
		if(vlisteners != null && (this.vlisteners == null || this.vlisteners.size() <= vlisteners.size()) ){
			this.vlisteners = vlisteners;
			
			for(int i=0; i<listeners.size(); i++){
				listeners.get(i).updateListeners(vlisteners);
			}
		}
	}

	public ArrayList<String> getCommands() {
		if(commands == null){
			try {
				commands = rmiClient.getCommands();
			} catch (RemoteException e) {}
		}
		
		return commands;
	}

	public Map<String, VirtualListener> getListeners() {
		if(vlisteners == null){
			try {
				vlisteners = rmiClient.getListeners();
			} catch (RemoteException e) {}
		}
		
		return vlisteners;
	}
	
	public String getID(){
		try {
			return rmiClient.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getUniqueID(){
		try {
			return rmiClient.getUniqueID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
