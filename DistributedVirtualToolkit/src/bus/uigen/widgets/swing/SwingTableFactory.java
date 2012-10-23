package bus.uigen.widgets.swing;import javax.swing.JTable;import javax.swing.table.TableModel;import bus.uigen.widgets.VirtualContainer;import bus.uigen.widgets.table.TableFactory;import bus.uigen.widgets.table.VirtualTable;

public class SwingTableFactory implements TableFactory  {	static int id;
	public VirtualTable createTable () {		/*
		Container panel = new JPanel();		panel.setName("" + getNewID());
		//panel.setBackground(Color.white);
		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJTable();
	}	 static int getNewID() {		return id++;	}	//public static JPanel createJPanel () {	public static VirtualTable createJTable () {		JTable panel = new JTable();				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualTable toReturn = SwingTable.virtualTable(panel);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	public  VirtualTable createTable (Object treeModel) {		return createJTable((TableModel) treeModel);			}	public static VirtualTable createJTable (TableModel treeModel) {		JTable panel = new JTable(treeModel);				panel.setName("" + getNewID());		//panel.setBackground(Color.white);		VirtualTable toReturn = SwingTable.virtualTable(panel);		toReturn.init();		return toReturn;					}	public VirtualContainer createContainer() {		return createJTable();	}		public VirtualTable createTable(Object[][] data, String[] columnNames){		VirtualTable toReturn = new SwingTable(data,columnNames);		toReturn.init();		return toReturn;			}  
 }
