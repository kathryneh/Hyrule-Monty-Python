package bus.uigen.widgets.tree;public class TreeSelector  {	static TreeFactory factory;	//static PanelFactory factory = new AWTPanelFactory();
	  public static void setTreeFactory (TreeFactory newVal) {
		factory = newVal;  }  public static  VirtualTree createTree() {	  return factory.createTree();
	    }  public static VirtualTree createTree (Object treeModel) {	  return factory.createTree(treeModel);  }  public static VirtualTree createTree (Object[] value) {	  return factory.createTree(value);  }
}