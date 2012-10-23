package bus.uigen.distributed.nongwt;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import bus.uigen.distributed.client.CommandsListener;
import bus.uigen.widgets.events.VirtualListener;

public interface RmiClientEnd extends Remote, Serializable{

	public void setID(String userDefinedID) throws RemoteException;
	public String getID() throws RemoteException;
	public String getUniqueID() throws RemoteException;
	public void close() throws RemoteException;
	
	public ArrayList<String> getCommands() throws RemoteException;
	public Map<String, VirtualListener> getListeners() throws RemoteException;
	
	public void send(String command) throws RemoteException;
	public void updateCommands(ArrayList<String> commands) throws RemoteException;
	public void addCommandsListener(CommandsListener listener) throws RemoteException;
	
	public void sendListener(VirtualListener listener, String id) throws RemoteException;
	public void updateListeners(Map<String, VirtualListener> listeners) throws RemoteException;

}
