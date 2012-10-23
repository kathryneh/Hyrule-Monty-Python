package bus.uigen.widgets;


public class GridLayoutSelector{
	public static final String COMMAND= ".create(";
	static GridLayoutFactory factory;
	
	public static void setGridLayoutFactory(GridLayoutFactory newVal){
		factory = newVal;
	}
	
	public static VirtualGridLayout createLayout(){
		String layoutID = VirtualToolkit.getObjectID(VirtualGridLayout.class);
		VirtualGridLayout toReturn = execCreate(layoutID);
		
		if(VirtualToolkit.isDistributed()){
			String command = VirtualGridLayout.COMMAND_LABEL+ layoutID + COMMAND + ")";
			VirtualToolkit.sendCommand(command);
		}
		
		return toReturn;
	}
	
	public static VirtualGridLayout execCreate(String layoutID){
		  if(!VirtualToolkit.containObjID(layoutID)){
			  VirtualGridLayout toReturn = factory.createLayout();
			  if(layoutID != null){
				  VirtualToolkit.associate(layoutID, toReturn);
				  toReturn.setID(layoutID);
			  }
			  return toReturn;
		  }else{
			  return (VirtualGridLayout) VirtualToolkit.getObjectByID(layoutID);
		  }
		
	}
	
	public static VirtualGridLayout createLayout(int rows, int cols){
		String layoutID = VirtualToolkit.getObjectID(VirtualGridLayout.class);
		VirtualGridLayout toReturn = execCreate(layoutID, rows, cols);
		
		if(VirtualToolkit.isDistributed()){
			String command = VirtualGridLayout.COMMAND_LABEL+ layoutID + COMMAND + rows +","+ cols+")";
			VirtualToolkit.sendCommand(command);
		}
		
		return toReturn;
	}
	
	public static VirtualGridLayout execCreate(String layoutID, int rows, int cols){
		  if(!VirtualToolkit.containObjID(layoutID)){
			  VirtualGridLayout toReturn = factory.createLayout(rows, cols);
			  if(layoutID != null){
				  VirtualToolkit.associate(layoutID, toReturn);
				  toReturn.setID(layoutID);
			  }
			  return toReturn;
		  }else{
			  return (VirtualGridLayout) VirtualToolkit.getObjectByID(layoutID);
		  }
	}
}