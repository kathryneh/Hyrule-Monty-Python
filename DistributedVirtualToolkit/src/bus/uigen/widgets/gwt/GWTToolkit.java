package bus.uigen.widgets.gwt;

import bus.uigen.distributed.gwt.GWTProxyGWTServerEndFactory;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.LabelSelector;
import bus.uigen.widgets.NumberFormatSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.ProxyGWTServerEndSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;

public class GWTToolkit extends VirtualToolkit{
	
	public GWTToolkit(){
		select();
	}
	
	public GWTToolkit(boolean isDistributed, String id){
		init(isDistributed, id);
	}
	
	public void select(){
		ButtonSelector.setButtonFactory(new GWTButtonFactory());
		FrameSelector.setFrameFactory(new GWTFrameFactory());
		GridLayoutSelector.setGridLayoutFactory(new GWTGridLayoutFactory());
		LabelSelector.setLabelFactory(new GWTLabelFactory());
		PanelSelector.setPanelFactory(new GWTPanelFactory());
		ProxyGWTServerEndSelector.setProxyGWTServerEndFactory(new GWTProxyGWTServerEndFactory());
		TextFieldSelector.setTextFieldFactory(new GWTTextFieldFactory());
		NumberFormatSelector.setNumberFormatFactory(new GWTNumberFormatFactory());
	}
	
	public void startFrame(VirtualFrame frame) {
		receiveStartFrameCommand(frame);
		
		if(frame != null && VirtualToolkit.isDistributed()){
			VirtualToolkit.sendCommand(COMMAND_LABEL+COMMAND_START+frame.getID()+")");
		}
	}

	public void receiveStartFrameCommand(VirtualFrame frame) {
		//Do nothing
	}
	
	public void sleep(long milleseconds){
		
	}
}