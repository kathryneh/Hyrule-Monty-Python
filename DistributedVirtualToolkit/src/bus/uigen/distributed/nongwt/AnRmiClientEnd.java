package bus.uigen.distributed.nongwt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

import bus.uigen.distributed.client.CommandsListener;
import bus.uigen.distributed.server.RegistrarStarter;
import bus.uigen.distributed.server.RmiServerEnd;
import bus.uigen.widgets.events.VirtualListener;

public class AnRmiClientEnd extends UnicastRemoteObject implements RmiClientEnd {
	
	ArrayList<CommandsListener> listeners = new ArrayList<CommandsListener>();
	
	String userDefinedID;
	String uniqueID;
	String nameOnServer;
	

	public AnRmiClientEnd() throws RemoteException{
		//init(userDefinedID);
	}
	
	private void init(String userDefinedID) throws RemoteException{
		this.uniqueID = userDefinedID+ System.currentTimeMillis();
		
		nameOnServer = 	"//"+RegistrarStarter.getHostName()+":"+RegistrarStarter.PORT+"/"+uniqueID;
		
		RegistrarStarter.getRegistrar().registerRmiClientEnd(nameOnServer, this);
		
	}
	
	
	
	public void close() throws RemoteException{
		try {
			Naming.unbind(nameOnServer);
			//TODO:remove from RmiServerEnd
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void send(String command) throws RemoteException {
		RmiServerEnd registrar = RegistrarStarter.getRegistrar();
		
		registrar.broadcastCommand(command);
	}

	public void setID(String userDefinedID) throws RemoteException {
		this.userDefinedID = userDefinedID;
		init(userDefinedID);
	}
	
	public synchronized void updateCommands(ArrayList<String> commands){
		for(int i=0; i<listeners.size(); i++){
			listeners.get(i).updateCommands(commands);
		}
	}
	
	public void updateListeners(Map<String, VirtualListener> vlisteners){
		for(int i=0; i<listeners.size(); i++){
			this.listeners.get(i).updateListeners(vlisteners);
		}		
	}

	public void addCommandsListener(CommandsListener listener) throws RemoteException {
		listeners.add(listener);
	}
	
	public ArrayList<String> getCommands() throws RemoteException{
		return RegistrarStarter.getRegistrar().getCommands();
	}
	
	public Map<String, VirtualListener> getListeners() throws RemoteException{
		return RegistrarStarter.getRegistrar().getListeners();
	}
	
	public String getID(){
		return userDefinedID;
	}
	
	public String getUniqueID(){
		return uniqueID;
	}
	
	public void sendListener(VirtualListener listener, String id) throws RemoteException{
		RegistrarStarter.getRegistrar().broadcastListener(listener, id);
	}

}
