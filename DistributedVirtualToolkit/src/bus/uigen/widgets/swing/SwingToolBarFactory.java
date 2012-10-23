package bus.uigen.widgets.swing;import javax.swing.JToolBar;import bus.uigen.widgets.ToolBarFactory;import bus.uigen.widgets.VirtualToolBar;

public class SwingToolBarFactory implements ToolBarFactory {	static int id;
	public VirtualToolBar createToolBar () {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJToolBar();
	}	public VirtualToolBar createToolBar (int direction) {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJToolBar(direction);	}	 static int getNewID() {		return id++;	}	//public static JPanel createJPanel () {	public static VirtualToolBar createJToolBar () {		JToolBar panel = new JToolBar();				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualToolBar toReturn = SwingToolBar.virtualToolBar(panel);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public static VirtualToolBar createJToolBar (int direction) {		JToolBar panel = new JToolBar(direction);				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualToolBar toReturn = SwingToolBar.virtualToolBar(panel);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	/*	public VirtualToolBar createToolBar() {		return createJToolBar();	}	*/  
 }
