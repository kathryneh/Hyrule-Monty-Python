package bus.uigen.distributed.client;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.ProxyGWTServerEndSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualGridLayout;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;


public class CommandInterpreter implements CommandsListener {
	ArrayList<String> commands;
	Map<String, VirtualListener> vlisteners = new TreeMap<String, VirtualListener>();
	int commandsCompleted = 0;
	
	ProxyGWTServerEnd proxy;
	
	public CommandInterpreter(String id){
		proxy = ProxyGWTServerEndSelector.create(id);
		proxy.setID(id);
		proxy.addCommandsListener(this);
	}
	
	public void updateCommands(ArrayList<String> commands) {
		if(commands != null && (this.commands == null || this.commands.size() < commands.size())){
			this.commands = commands;
			runCommands();
		}
	}
	
	public void updateListeners(Map<String, VirtualListener> vlisteners) {
		if(vlisteners != null && (this.vlisteners == null || this.vlisteners.size() < vlisteners.size())){
			this.vlisteners = vlisteners;
		}
	}
	
	public void runCommands(){
		while(commandsCompleted < commands.size()){
			commandsCompleted++;
			runCommand(commands.get(commandsCompleted-1));
		}
	}
	
	public void sendListener(VirtualListener listener, String id){
		proxy.sendListener(listener, id);
	}
	
	public void send(String command){
		proxy.send(command);
	}
	
	public void checkCommands(){
		proxy.checkCommands();
	}
	
	public void checkListeners(){
		proxy.checkListeners();
	}
	
	public ProxyGWTServerEnd getProxy(){
		return proxy;
	}
	
	private void runComponentCommand(String command){
		command = command.substring(VirtualComponent.COMMAND_LABEL.length());
		
		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);
		
		VirtualComponent widget = (VirtualComponent) VirtualToolkit.getObjectByID(widgetID);
		
		if(command.startsWith(VirtualComponent.SET_SIZE_COMMAND)){
			String argsStr = command.substring(VirtualComponent.SET_SIZE_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			if(args.length == 2){
				widget.execSetSize(Integer.parseInt(args[0]), Integer.parseInt(args[0]));
			}
		}
		
	}
	
	private void runFrameCommand(String command){
		command = command.substring(VirtualFrame.COMMAND_LABEL.length());
		
		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);
		
		if(command.startsWith(FrameSelector.COMMAND)){
			String args = command.substring(FrameSelector.COMMAND.length(), command.lastIndexOf(')'));
			if(args.length() == 0){
				FrameSelector.execCreate(widgetID);
			}else{
				FrameSelector.execCreate(widgetID, args);
			}
		}
		
	}
	
	private void runTextFieldCommand(String command){
		command = command.substring(VirtualTextField.COMMAND_LABEL.length());
		
		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);
		
		if(command.startsWith(TextFieldSelector.COMMAND)){
			String args = command.substring(TextFieldSelector.COMMAND.length(), command.lastIndexOf(')'));
			if(args.length() == 0){
				TextFieldSelector.execCreate(widgetID);
			}else{
				TextFieldSelector.execCreate(widgetID, args);
			}
		}else if(command.startsWith(VirtualTextField.ADD_ACTION_LISTENER_COMMAND)){
			VirtualTextField widget = (VirtualTextField) VirtualToolkit.getObjectByID(widgetID);
			
			String argsStr = command.substring(VirtualButton.ADD_ACTION_LISTENER_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			String listenerID = args[1];
			while(!vlisteners.containsKey(listenerID)){};
			
			VirtualActionListener listener = (VirtualActionListener) vlisteners.get(listenerID);
			widget.execAddActionListener(listener, args[2]);
			
		}else if(command.startsWith(VirtualTextField.BLOCK_ACTION_EVENT_FORWARDING_COMMAND)){
			VirtualTextField widget = (VirtualTextField) VirtualToolkit.getObjectByID(widgetID);
			
			String argsStr = command.substring(VirtualTextField.BLOCK_ACTION_EVENT_FORWARDING_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			String val = args[1];
			
			widget.execBlockActionEventForwarding(Boolean.parseBoolean(val));
		}
		
	}
	
	private void runButtonCommand(String command){
		
		command = command.substring(VirtualButton.COMMAND_LABEL.length());
		
		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);
		
		if(command.startsWith(ButtonSelector.COMMAND)){
			String args = command.substring(FrameSelector.COMMAND.length(), command.lastIndexOf(')'));
			if(args.length() == 0){
				ButtonSelector.execCreate(widgetID);
			}else{
				ButtonSelector.execCreate(widgetID, args);
			}
		}else if(command.startsWith(VirtualButton.ADD_ACTION_LISTENER_COMMAND)){
			VirtualButton button = (VirtualButton) VirtualToolkit.getObjectByID(widgetID);
			
			String argsStr = command.substring(VirtualButton.ADD_ACTION_LISTENER_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			String listenerID = args[1];
			while(!vlisteners.containsKey(listenerID)){};
			
			VirtualActionListener listener = (VirtualActionListener) vlisteners.get(listenerID);
			button.execAddActionListener(listener, args[2]);
			
		}else if(command.startsWith(VirtualButton.BLOCK_ACTION_EVENT_FORWARDING_COMMAND)){
			VirtualButton widget = (VirtualButton) VirtualToolkit.getObjectByID(widgetID);
			
			String argsStr = command.substring(VirtualTextField.BLOCK_ACTION_EVENT_FORWARDING_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			String val = args[1];
			
			widget.execBlockActionEventForwarding(Boolean.parseBoolean(val));
		}
		
	}
	
	private void runContainerCommand(String command){
		
		command = command.substring(VirtualContainer.COMMAND_LABEL.length());
					
		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);
		
		VirtualContainer widget = (VirtualContainer) VirtualToolkit.getObjectByID(widgetID);
		
		if(command.startsWith(PanelSelector.COMMAND)){
			PanelSelector.execCreate(widgetID);
		}else if(command.startsWith(VirtualContainer.ADD_COMMAND)){
			String argsStr = command.substring(VirtualContainer.ADD_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			VirtualComponent arg1 = (VirtualComponent) VirtualToolkit.getObjectByID(args[1]);
			if(args.length == 2){
				widget.execAdd(arg1);
			}
		}else if(command.startsWith(VirtualContainer.SET_LAYOUT_COMMAND)){
			String argsStr = command.substring(VirtualContainer.SET_LAYOUT_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			VirtualLayout arg1 = (VirtualLayout) VirtualToolkit.getObjectByID(args[1]);
			widget.execSetLayout(arg1);
			
			
		}
		
	}
	
	private void runTextComponentCommand(String command){
		
		command = command.substring(VirtualTextComponent.COMMAND_LABEL.length());
					
		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);
		
		VirtualTextComponent widget = (VirtualTextComponent) VirtualToolkit.getObjectByID(widgetID);
		
		if(command.startsWith(VirtualTextComponent.SET_TEXT_COMMAND)){

			String argsStr = command.substring(VirtualTextComponent.SET_TEXT_COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			if(VirtualToolkit.getUniqueID().equals(args[0])){
				return;
			}
			
			widget.execSetText(args[1]);
		}
		
	}
	
	private void runGridLayoutCommand(String command){
		
		command = command.substring(VirtualGridLayout.COMMAND_LABEL.length());
		
		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);
		
		if(command.startsWith(GridLayoutSelector.COMMAND)){
			String argsStr = command.substring(GridLayoutSelector.COMMAND.length(), command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			if(args.length > 0){
				GridLayoutSelector.execCreate(widgetID, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			}else{
				GridLayoutSelector.execCreate(widgetID);
			}
		}
		
	}
	
	public synchronized void runCommand(String command){
		
		if(command.startsWith(VirtualToolkit.COMMAND_LABEL)){
			
			VirtualToolkit.runCommand(command);
			
		}else if(command.startsWith(VirtualActionEvent.COMMAND_LABEL)){
			
			VirtualActionEvent.runCommand(command);
			
		}else if(command.startsWith(VirtualComponent.COMMAND_LABEL)){
			
			runComponentCommand(command);
			
		}else if(command.startsWith(VirtualFrame.COMMAND_LABEL)){
			
			runFrameCommand(command);
			
		}else if(command.startsWith(VirtualTextField.COMMAND_LABEL)){
			
			runTextFieldCommand(command);
			
		}else if(command.startsWith(VirtualButton.COMMAND_LABEL)){
			
			runButtonCommand(command);
			
		}else if(command.startsWith(VirtualContainer.COMMAND_LABEL)){
			
			runContainerCommand(command);
			//TODO: order broadcasts
			
		}else if(command.startsWith(VirtualTextComponent.COMMAND_LABEL)){
			
			runTextComponentCommand(command);
			//TODO: order broadcasts
			
		}else if(command.startsWith(VirtualGridLayout.COMMAND_LABEL)){
			
			runGridLayoutCommand(command);
			//TODO: order broadcasts
			
		}
	}

}
