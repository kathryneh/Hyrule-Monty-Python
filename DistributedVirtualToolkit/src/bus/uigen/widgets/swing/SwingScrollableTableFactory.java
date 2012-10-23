package bus.uigen.widgets.swing;

import bus.uigen.widgets.table.ScrollableTableFactory;
import bus.uigen.widgets.table.VirtualScrollableTable;

import javax.swing.table.TableModel;

public class SwingScrollableTableFactory implements ScrollableTableFactory{

	
	public VirtualScrollableTable createTable() {
		VirtualScrollableTable toReturn = new SwingScrollableTable();
		toReturn.init();
		return toReturn;
		
	}

	
	public VirtualScrollableTable createTable(Object tableModel) {
		VirtualScrollableTable toReturn = new SwingScrollableTable((TableModel) tableModel);
		toReturn.init();
		return toReturn;
		
	}

	
	public VirtualScrollableTable createTable(Object[][] data, String[] columnNames) {
		VirtualScrollableTable toReturn = new SwingScrollableTable(data,columnNames);
		toReturn.init();
		return toReturn;
		
	}
	
	
}