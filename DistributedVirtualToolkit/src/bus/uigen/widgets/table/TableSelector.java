package bus.uigen.widgets.table;public class TableSelector  {	static TableFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setTableFactory (TableFactory newVal) {
		factory = newVal;  }  public static  VirtualTable createTable() {	  return factory.createTable();
	    }  public static VirtualTable createTable (Object treeModel) {	  return factory.createTable(treeModel);  }    public static VirtualTable createTable(Object[][] data, String[] columnNames){	  return factory.createTable(data, columnNames);  }
}