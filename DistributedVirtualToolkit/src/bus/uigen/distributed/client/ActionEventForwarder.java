package bus.uigen.distributed.client;

import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class ActionEventForwarder implements VirtualActionListener {
	VirtualComponent parent;
	
	public ActionEventForwarder(){
		
	}
	
	public ActionEventForwarder(VirtualComponent parent){
		this.parent = parent;
	}
	
	public void actionPerformed(VirtualActionEvent e) {
		if(parent instanceof VirtualButton && ((VirtualButton) parent).isBlockingActionEventForwarding()){
			return;
		}else if(parent instanceof VirtualTextField && ((VirtualTextField) parent).isBlockingActionEventForwarding()){
			return;
		}
		
		String originator = VirtualToolkit.getUniqueID();
		while(originator == null){
			originator = VirtualToolkit.getUniqueID();
		}
		
		String widgetID = parent.getID();
		
		String cmd = e.getActionCommand();
		long when = e.when();
		int type = e.getType();
		int modifiers = e.modifiers();
		
		String command = VirtualActionEvent.COMMAND_LABEL 
						+ VirtualActionEvent.FIRE_COMMAND
						+ originator +","
						+ widgetID + ","
						+ cmd +","
						+ when +","
						+ type +","
						+ modifiers +")";
		
		//CommandSender sender = new CommandSender(command);
		//sender.start();
		VirtualToolkit.sendCommand(command);
		
	}
	
	/*class CommandSender extends Thread{
		String command;
		public CommandSender(String command){
			this.command = command;
		}
		
		public void run(){
			VirtualToolkit.sendCommand(command);
		}
	}*/

}
