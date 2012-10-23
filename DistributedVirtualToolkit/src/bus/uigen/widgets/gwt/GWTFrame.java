package bus.uigen.widgets.gwt;



import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualPopupMenu;
import bus.uigen.widgets.VirtualToolkit;

public class GWTFrame extends GWTContainer implements VirtualFrame, VirtualContainer{
	String id;
	
	
	public GWTFrame(){	
	}
	
	public GWTFrame(String id){
		this.id = id;
	}
	
	public RootPanel getPanel(){
		if(id==null){
			return RootPanel.get();
		}else{
			return RootPanel.get(id);
		}
	}
	
	public void add(Widget w){
		getPanel().add(w);
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
			add((Widget)c.getPhysicalComponent());		
		}else{
			layout.add(c);
		}
	}
	
	public void clear(){
		getPanel().clear();
	}
	

	public void removeAll() {
		getPanel().clear();
		
	}
	
	public String getTitle() {
		return getPanel().getTitle();
	}
	

	public void setTitle(String label) {
		getPanel().setTitle(label);
		
	}
	

	public void remove(int pos) {
		getPanel().remove(pos);
	}
	
	@Override
	public void execSetLayout(VirtualLayout l){
		if(l == null) return;
		layout = (GWTLayout) l;
		this.getPanel().add(((GWTLayout) l).getComponent());
	}
	
	public void execSetSize(int width, int height){
		getPanel().setPixelSize(width, height);
	}
	
	@Override
	public void add(VirtualPopupMenu menu) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void addWindowListener(Object newVal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public VirtualContainer getContentPane() {
		return this;
	}

	@Override
	public VirtualMenuBar getMenuBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContentPane(VirtualContainer container) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultCloseOperation(int arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMenuBar(VirtualMenuBar newVal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResizable(boolean newVal) {
		// TODO Auto-generated method stub
		
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
	public void remove(VirtualComponent c) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setLayout(Object layoutManager) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addComponentListener(Object cl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	public void asyncExec(Runnable runnable) {
		runnable.run();
	}
	
	public void syncExec(Runnable runnable) {
		runnable.run();
	}

	
}