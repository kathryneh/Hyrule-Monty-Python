package bus.uigen.distributed.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.events.VirtualListener;

public class AnRmiServerEnd extends UnicastRemoteObject implements RmiServerEnd {
	ArrayList<String> clients = new ArrayList<String>();
	ArrayList<String> commands = new ArrayList<String>();
	Map<String, VirtualListener> listeners = new TreeMap<String, VirtualListener>();
	
	public AnRmiServerEnd() throws RemoteException{
		
	}

	public void registerRmiClientEnd(String rmiClientEndID, RmiClientEnd rmiClientEnd) throws RemoteException {

		try {
			Naming.rebind(rmiClientEndID, rmiClientEnd);
			
			if(!clients.contains(rmiClientEndID)){
				clients.add(rmiClientEndID);
			}
			
			//System.out.println("registered "+rmiClientEndID);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	class MessageSender extends Thread{
		RmiClientEnd rmiClient;
		ArrayList<String> cmds;
		
		@SuppressWarnings("unchecked")
		public MessageSender(RmiClientEnd rmiClient, ArrayList<String> commands){
			this.rmiClient = rmiClient;
			cmds = (ArrayList<String>) commands.clone();
		}
		
		public void run(){
			try{
				rmiClient.updateCommands(cmds);
			}catch (Exception e){
				//e.printStackTrace();
			}
		}
	}

	public synchronized void broadcastCommand(String command) throws RemoteException {
		//System.out.print("broadcasting command: "+command +"...");
		commands.add(command);
		
		for(int i=0; i<clients.size(); i++){
			try {
				String client = clients.get(i);
				
				RmiClientEnd rmiClient = (RmiClientEnd) Naming.lookup(clients.get(i));
				Thread messageSender = new MessageSender(rmiClient, commands);
				messageSender.start();
				
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		
		//System.out.println("finished");
	}
	
	public void broadcastListener(VirtualListener listener, String id) throws RemoteException{
		listeners.put(id, listener);
		
		
		for(int i=0; i<clients.size(); i++){
			try {
				String client = clients.get(i);
				
				RmiClientEnd rmiClient = (RmiClientEnd) Naming.lookup(clients.get(i));
				rmiClient.updateListeners(listeners);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}
	
	public ArrayList<String> getCommands(){
		return commands;
	}
	
	public Map<String, VirtualListener> getListeners(){
		return listeners;
	}

}
