package bus.uigen.widgets.awt;

import bus.uigen.widgets.VirtualFlowLayout;
import java.awt.FlowLayout;

public class AWTFlowLayout extends AWTLayout implements VirtualFlowLayout{
	public AWTFlowLayout(){
		super(new FlowLayout());
	}
	
	public AWTFlowLayout(FlowLayout l){
		component = l;
	}
}