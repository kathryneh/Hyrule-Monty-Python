package bus.uigen.widgets.awt;import bus.uigen.widgets.DelegatePanelFactory;
import bus.uigen.widgets.VirtualDelegatePanel;
public class AWTDelegatePanelFactory implements DelegatePanelFactory {	
	public VirtualDelegatePanel createDelegatePanel () {
		DelegatePanel delegatePanel = new DelegatePanel();
		//delegatePanel.setBackground(Color.white);				VirtualDelegatePanel toReturn = AWTDelegatePanel.virtualDelegatePanel(delegatePanel);				toReturn.init();		return toReturn;				//return new DelegateJPanel();
	}	  
 }
