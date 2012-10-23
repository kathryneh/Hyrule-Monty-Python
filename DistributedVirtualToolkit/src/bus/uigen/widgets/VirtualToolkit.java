package bus.uigen.widgets;

import java.util.Map;
import java.util.TreeMap;

import bus.uigen.distributed.client.CommandInterpreter;
import bus.uigen.widgets.events.VirtualListener;

//import bus.uigen.widgets.universal.AUniversalWidget;

public abstract class VirtualToolkit{
	public static final String COMMAND_LABEL = "VIRTUALTOOLKIT:";
	public static final String COMMAND_START = "start(";
	
	static VirtualToolkit defaultToolkit;// = new GWTToolkit();
	
	static boolean widgetsRegistered = false;
	public static CommandInterpreter interpreter;
	public static Map<String, Object> idToWidget = new TreeMap<String, Object>();
	
	static boolean started = false;
	static boolean shouldStart = false;
	static String frameToStart;
	
	protected void init(boolean isDistributed, String id){
		if(id.contains(",")){
			throw new RuntimeException("ID may not contain commas");
		}
		select();
		if(isDistributed){
			interpreter = new CommandInterpreter(id);
		}
	}
	
	protected boolean maybeRegisterWidgets() {
		if (widgetsRegistered) return false;
		//AUniversalWidget.registerUniversalWidgetClasses();
		widgetsRegistered = true;
		return true;
	}
	
	public void select(){}
	
	public abstract void startFrame(VirtualFrame frame);
	public abstract void receiveStartFrameCommand(VirtualFrame frame);
	
	public static void setDefaultToolkit(VirtualToolkit toolkit){
		defaultToolkit = toolkit;
		if(VirtualToolkit.isDistributed()){
			interpreter.checkListeners();
			interpreter.checkCommands();
		}
	}
	
	public static VirtualToolkit getDefaultToolkit(){
		return defaultToolkit;
	}
	
	public static void start(VirtualFrame frame){
		if(!VirtualToolkit.isDistributed()){
			defaultToolkit.receiveStartFrameCommand(frame);
			defaultToolkit.startFrame(frame);
			
		}else {
			defaultToolkit.startFrame(frame);
			//String widgetID = frame.getID();
			//VirtualToolkit.sendCommand(COMMAND_LABEL+COMMAND_START+widgetID+")");
		}
		//execStart(frame);
	}
	
	public static void execStart(VirtualFrame frame){
		/*if(started) return;
		started = true;
		defaultToolkit.startFrame(frame);*/
		if(defaultToolkit != null){
			defaultToolkit.receiveStartFrameCommand(frame);
		}
	}
	
	public synchronized static String getObjectID(Class objClass){
		String className = objClass.getName();
		className = className.substring(className.lastIndexOf('.')+1);
		String id = className+idToWidget.size();
		return id;
	}
	
	public static boolean isDistributed(){
		return interpreter != null;
	}
	
	public static void sendListener(VirtualListener listener, String id){
		interpreter.sendListener(listener, id);
	}
	
	public static void sendCommand(String command){
		interpreter.send(command);
	}
	
	public static void associate(String widgetID, Object obj){
		idToWidget.put(widgetID, obj);
	}
	
	public static boolean containObjID(String id){
		return id != null && idToWidget.containsKey(id);
	}
	
	public static Object getObjectByID(String widgetID){
		return idToWidget.get(widgetID);
	}
	
	public static String getID(){
		return interpreter.getProxy().getID();
	}
	
	public static String getUniqueID(){
		if(interpreter != null){
			return interpreter.getProxy().getUniqueID();
		}else{
			return "";
		}
	}
	
	public static void runCommand(String command){
		command = command.substring(COMMAND_LABEL.length());
		
		if(command.startsWith(COMMAND_START)){
			String frameID = command.substring(COMMAND_START.length(), command.lastIndexOf(')'));
			VirtualFrame frame = (VirtualFrame) VirtualToolkit.getObjectByID(frameID);
			
			VirtualToolkit.execStart(frame);
		}
		
	}
}