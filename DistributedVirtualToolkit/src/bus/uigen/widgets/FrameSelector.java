package bus.uigen.widgets;

	
	static FrameFactory factory;
	
		factory = newVal;
	  String widgetID = VirtualToolkit.getObjectID(VirtualFrame.class);
	  VirtualFrame toReturn = execCreate(widgetID);
	  if(VirtualToolkit.isDistributed()){
		  String command = VirtualFrame.COMMAND_LABEL+ widgetID + COMMAND +")";
		  VirtualToolkit.sendCommand(command);
	  }
	  
	  return toReturn;
		  
  
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
  
	VirtualFrame toReturn = execCreate(widgetID, title);
	
	if(VirtualToolkit.isDistributed()){
		String command = VirtualFrame.COMMAND_LABEL+ widgetID + COMMAND + title +")";
		VirtualToolkit.sendCommand(command);
	}
		  
	return toReturn;
		  
	
  
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