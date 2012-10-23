package bus.uigen.widgets.gwt;


import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Panel;

import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualToolkit;

public abstract class GWTContainer extends GWTComponent implements VirtualContainer{
	GWTLayout layout;

	public GWTContainer(){
		
	}
	
	public GWTContainer(Widget w){
		super(w);
	}
	
	public Panel getContainer(){
		return (Panel) component;
	}

	public int getHeight() {
		return getContainer().getOffsetHeight();
	}

	public String getName() {
		return getContainer().getStyleName();
	}

	
	public int getWidth() {
		return getContainer().getOffsetWidth();
	}

	public void setLayout(VirtualLayout l) {
		execSetLayout(l);
		if(VirtualToolkit.isDistributed()){
			String widgetID = this.getID();
			String lID = l.getID();
			String uniqueID = VirtualToolkit.getUniqueID();
			while (uniqueID == null){uniqueID = VirtualToolkit.getUniqueID();}
			VirtualToolkit.sendCommand(VirtualContainer.COMMAND_LABEL + widgetID + SET_LAYOUT_COMMAND + uniqueID + "," + lID + ")");
		}
	}
	
	public void execSetLayout(VirtualLayout l){
		if(l == null) return;
		layout = (GWTLayout) l;
		this.getContainer().add(((GWTLayout) l).getComponent());
		
	}
	
	public void add(VirtualComponent c){
		execAdd(c);
		if(VirtualToolkit.isDistributed()){
			String widgetID = this.getID();
			String cID = c.getID();
			String uniqueID = VirtualToolkit.getUniqueID();
			while (uniqueID == null){uniqueID = VirtualToolkit.getUniqueID();}
			VirtualToolkit.sendCommand(VirtualContainer.COMMAND_LABEL + widgetID + ADD_COMMAND + uniqueID + "," + cID + ")");
		}
	}
	
	public void execAdd(VirtualComponent c){
		if(layout == null){
			getContainer().add((Widget)c.getPhysicalComponent());		
		}else{
			layout.add(c);
		}
	}

	public boolean isVisible() {
		return getContainer().isVisible();
	}
	
	public void remove(VirtualComponent c) {
		getContainer().remove((Widget)c.getPhysicalComponent());
		
	}
	
	public void removeAll() {
		getContainer().clear();		
	}
	

	public void resize(int width, int height) {
		getContainer().setSize(""+width, ""+height);
		
	}

	@Override
	public void add(VirtualComponent c, int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(VirtualComponent c, Object constraint, int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(VirtualComponent c, Object constraint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(VirtualComponent c, String direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countComponents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VirtualComponent getComponent(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getComponentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VirtualComponent[] getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLayout(Object layoutManager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void layout() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}