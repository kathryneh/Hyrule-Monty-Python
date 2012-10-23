package bus.uigen.distributed.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import bus.uigen.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.events.VirtualListener;

public interface RmiServerEnd extends Remote {
	
	public static final String REGISTRAR_NAME = "RmiServerEnd";
	
	public void registerRmiClientEnd(String rmiClientEndID, RmiClientEnd rmiClientEnd) throws RemoteException;
	public void broadcastCommand(String command) throws RemoteException;
	public void broadcastListener(VirtualListener listener, String id) throws RemoteException;
	
	public ArrayList<String> getCommands() throws RemoteException;
	public Map<String, VirtualListener> getListeners() throws RemoteException;

}
