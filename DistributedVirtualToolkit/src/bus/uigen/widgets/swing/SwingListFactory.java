package bus.uigen.widgets.swing;import javax.swing.JList;import javax.swing.ListModel;import bus.uigen.widgets.ListFactory;import bus.uigen.widgets.VirtualContainer;import bus.uigen.widgets.VirtualList;

public class SwingListFactory implements ListFactory  {	static int id;
	public VirtualList createList () {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJList();
	}	 static int getNewID() {		return id++;	}	//public static JPanel createJPanel () {	public static VirtualList createJList () {		JList panel = new JList();				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualList toReturn = SwingList.virtualList(panel);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public  VirtualList createList (ListModel listModel) {		return createJList((ListModel) listModel);			}	public static VirtualList createJList (ListModel listModel) {		JList panel = new JList(listModel);				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualList toReturn = SwingList.virtualList(panel);		toReturn.init();		return toReturn;			}	public VirtualContainer createContainer() {		return createJList();	}	@Override	public VirtualList createList(Object listModel) {		// TODO Auto-generated method stub		return null;	}  
 }
