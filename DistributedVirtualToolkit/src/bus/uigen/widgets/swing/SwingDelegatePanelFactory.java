package bus.uigen.widgets.swing;import bus.uigen.widgets.DelegatePanelFactory;
import bus.uigen.widgets.VirtualDelegatePanel;
public class SwingDelegatePanelFactory implements DelegatePanelFactory {	
	public VirtualDelegatePanel createDelegatePanel () {
		DelegateJPanel delegatePanel = new DelegateJPanel();
		//delegatePanel.setBackground(Color.white);		VirtualDelegatePanel toReturn = SwingDelegatePanel.virtualDelegatePanel(delegatePanel);				toReturn.init();		return toReturn;		//return new DelegateJPanel();
	}	  
 }
