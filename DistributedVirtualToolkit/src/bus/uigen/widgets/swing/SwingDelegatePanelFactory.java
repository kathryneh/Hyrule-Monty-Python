package bus.uigen.widgets.swing;
import bus.uigen.widgets.VirtualDelegatePanel;
public class SwingDelegatePanelFactory implements DelegatePanelFactory {	
	public VirtualDelegatePanel createDelegatePanel () {
		DelegateJPanel delegatePanel = new DelegateJPanel();
		//delegatePanel.setBackground(Color.white);
	}	
 }