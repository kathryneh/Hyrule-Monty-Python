package bus.uigen.widgets;public class ListSelector  {	static ListFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setListFactory (ListFactory newVal) {
		factory = newVal;  }  public static  VirtualList createList() {	  return factory.createList();
	    }  public static VirtualList createList (Object treeModel) {	  return factory.createList(treeModel);  }
}