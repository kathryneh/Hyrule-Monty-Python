package bus.uigen.distributed.gwt;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.distributed.client.CommandsListener;
import bus.uigen.distributed.client.GWTServerEnd;
import bus.uigen.distributed.client.GWTServerEndAsync;
import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class GWTProxyGWTServerEnd implements ProxyGWTServerEnd{
	
	public final static String GWT_ENTRY_POINT = "GWTServerEnd";
	
	String ID;
	String uniqueID = "default";
	
	GWTServerEndAsync async;
	ArrayList<String> commands;
	ArrayList<CommandsListener> listeners = new ArrayList<CommandsListener>();
	Map<String, VirtualListener> vlisteners = new TreeMap<String, VirtualListener>();
	
	AsyncCallback<Void> voidCallback = new AsyncCallback<Void>(){
		public void onFailure(Throwable caught) {}
		public void onSuccess(Void result) {}
	};
	
	AsyncCallback<String> idCallback = new AsyncCallback<String>(){
		public void onFailure(Throwable caught) {}
		public void onSuccess(String result) {
			ID = result;
		}
	};
	
	AsyncCallback<String> uniqueIDCallback = new AsyncCallback<String>(){
		public void onFailure(Throwable caught) {}

		public void onSuccess(String result) {
			uniqueID = result;
			System.out.println("received unique ID");
		}
	};
	
	
	
	public GWTProxyGWTServerEnd(String userDefinedID){//GWTServerEndAsync async){
		init(userDefinedID);
	}
	
	private void init(String userDefinedID){
		async = (GWTServerEndAsync) GWT.create(GWTServerEnd.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) async;
		endpoint.setServiceEntryPoint(GWT.getModuleBaseURL()+GWT_ENTRY_POINT);
		
		async.setID(userDefinedID, voidCallback);
	}
	
	private class DelayedCommandSend extends Timer{
		String command;
		
		public DelayedCommandSend(String command){
			this.command = command;
		}
		
		public void run() {
			//System.out.println("Send:"+ System.currentTimeMillis());
			async.send(command, voidCallback);
		}
		
	}

	public synchronized void send(String command) {
		Timer timer = new DelayedCommandSend(command);
		//System.out.println("Send:"+ System.currentTimeMillis());
		timer.schedule(1);
		//timer.run();
		
	}
	
	private class DelayedListenerSend extends Timer{
		VirtualListener listener;
		String id;
		
		public DelayedListenerSend(VirtualListener listener, String id){
			this.listener = listener;
			this.id = id;
		}
		
		public void run() {
			async.sendListener(listener, id, voidCallback);
		}
		
	}

	public void sendListener(VirtualListener listener, String id) {
		Timer timer = new DelayedListenerSend(listener, id);
		timer.schedule(2);
		
	}
	
	boolean foundSetIDResult =false;
	boolean setIDResult = false;
	public void setID(String userDefinedID) {
		
		async.setID(userDefinedID, voidCallback);
		
		async.getID(idCallback);
		
		async.getUniqueID(uniqueIDCallback);
		
	}

	public void checkCommands() {
		
		Timer timer = new Timer(){
			AsyncCallback<ArrayList<String>> callback = new AsyncCallback<ArrayList<String>>() {

				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}

				public void onSuccess(ArrayList<String> result) {
					updateCommands(result);
				}
				
			};
			
			public void run(){
				async.getCommands(callback);
				
			}
		};
		timer.scheduleRepeating(100);
	}
	


	public void checkListeners() {
		
		Timer timer = new Timer(){
			AsyncCallback<Map<String, VirtualListener>> callback = new AsyncCallback<Map<String, VirtualListener>>() {

				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}

				public void onSuccess(Map<String, VirtualListener> result) {
					updateListeners(result);
				}
				
			};
			
			public void run(){
				async.getListeners(callback);
				
			}
		};
		timer.scheduleRepeating(100);
	}
	
	private void updateCommands(ArrayList<String> commands){
		if(commands != null && (this.commands == null || this.commands.size() <= commands.size()) ){
			this.commands = commands;
			
			for(int i=0; i<listeners.size(); i++){
				listeners.get(i).updateCommands(commands);
			}
		}
	}
	
	private void updateListeners(Map<String, VirtualListener> vlisteners){
		if(vlisteners != null && (this.vlisteners == null || this.vlisteners.size() <= vlisteners.size()) ){
			this.vlisteners = vlisteners;
			
			for(int i=0; i<listeners.size(); i++){
				listeners.get(i).updateListeners(vlisteners);
			}
		}
	}

	public void addCommandsListener(CommandsListener listener) {
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public String getID(){
		return this.ID;
	}
	
	public String getUniqueID(){
		return this.uniqueID;
	}

}
