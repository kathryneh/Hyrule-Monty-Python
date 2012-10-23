package bus.uigen.widgets;
public class FrameSelector  {	public static final String COMMAND= ".create(";
	
	static FrameFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setFrameFactory (FrameFactory newVal) {
		factory = newVal;  }  public static  VirtualFrame createFrame() {
	  String widgetID = VirtualToolkit.getObjectID(VirtualFrame.class);
	  VirtualFrame toReturn = execCreate(widgetID);
	  if(VirtualToolkit.isDistributed()){
		  String command = VirtualFrame.COMMAND_LABEL+ widgetID + COMMAND +")";
		  VirtualToolkit.sendCommand(command);
	  }
	  
	  return toReturn;
		    }
  
  public static VirtualFrame execCreate(String widgetID){
	  if(!VirtualToolkit.containObjID(widgetID)){
		  VirtualFrame toReturn = factory.createFrame();
		  if(widgetID != null){
			  VirtualToolkit.associate(widgetID, toReturn);
			  toReturn.setID(widgetID);
		  }
		  return toReturn;
	  }else{
		  return (VirtualFrame) VirtualToolkit.getObjectByID(widgetID);
	  }
  }
    public static  VirtualFrame createFrame(String title) {	String widgetID = VirtualToolkit.getObjectID(VirtualFrame.class);
	VirtualFrame toReturn = execCreate(widgetID, title);
	
	if(VirtualToolkit.isDistributed()){
		String command = VirtualFrame.COMMAND_LABEL+ widgetID + COMMAND + title +")";
		VirtualToolkit.sendCommand(command);
	}
		  
	return toReturn;
		  
	  }
  
  public static VirtualFrame execCreate(String widgetID, String title){
	  if(!VirtualToolkit.containObjID(widgetID)){
		  VirtualFrame toReturn = factory.createFrame(title);
		  if(widgetID != null){
			  VirtualToolkit.associate(widgetID, toReturn);
			  toReturn.setID(widgetID);
		  }
		  return toReturn;
	  }else{
		  return (VirtualFrame) VirtualToolkit.getObjectByID(widgetID);
	  }
  }
  
  
}