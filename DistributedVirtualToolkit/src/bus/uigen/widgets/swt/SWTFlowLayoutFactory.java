package bus.uigen.widgets.swt;

import bus.uigen.widgets.VirtualFlowLayout;
import bus.uigen.widgets.FlowLayoutFactory;

public class SWTFlowLayoutFactory implements FlowLayoutFactory{
	
	public VirtualFlowLayout createFlowLayout(){
		return new SWTFlowLayout();
	}
}