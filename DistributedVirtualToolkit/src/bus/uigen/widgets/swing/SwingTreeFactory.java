package bus.uigen.widgets.swing;import javax.swing.tree.TreeModel;import bus.uigen.widgets.tree.TreeFactory;import bus.uigen.widgets.tree.VirtualTree;
public class SwingTreeFactory implements TreeFactory  {	
	public VirtualTree createTree () {		return new SwingTree();
	}	 		public  VirtualTree createTree (Object treeModel) {		VirtualTree toReturn = new SwingTree((TreeModel) treeModel);		toReturn.init();		return toReturn;			}	public VirtualTree createTree (TreeModel treeModel) {		VirtualTree toReturn = new SwingTree(treeModel);		toReturn.init();		return toReturn;			}		public  VirtualTree createTree (Object[] value){		VirtualTree toReturn = new SwingTree(value);		toReturn.init();		return toReturn;	}	  
 }
