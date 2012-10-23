package bus.uigen.widgets.swing;

import java.awt.Component;
import java.awt.event.ItemListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import bus.uigen.widgets.VirtualComboBox;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingComboBox extends SwingComponent implements VirtualComboBox {
	//JComboBox getComboBox();
	public SwingComboBox (JComboBox theComboBox) {
		super (theComboBox);
		//getComboBox() = theComboBox;		
		
	}
	public SwingComboBox () {		
		
	}
	public JComboBox getComboBox() {
		return (JComboBox) component;
	}
	public void init (Object[] choices) {
		Component c = new JComboBox (choices);
		super.init(c);		
	}
	public void setEditable (boolean newVal) {
		getComboBox().setEditable(newVal);
	}
	public boolean isEditable() {
		return getComboBox().isEditable();
	}
	public int getItemCount() {
		return getComboBox().getItemCount();
	}
	public void setLightWeightPopupEnabled(boolean newVal) {
		getComboBox().setLightWeightPopupEnabled(newVal);
	}
	public void setModel(ComboBoxModel newVal) {
		getComboBox().setModel(newVal);
	}
	public void setModel(Object newVal) {
		setModel((ComboBoxModel) newVal);
	}
	public void updateUI() {
		getComboBox().updateUI();
	}
	public void removeItem(Object item) {
		getComboBox().removeItem(item);
	}
	public void addItemListener (ItemListener item) {
		getComboBox().addItemListener(item);
	}
	public void addItemListener (Object item) {
		getComboBox().addItemListener((ItemListener)item);
	}
	public void setMaximumRowCount (int num) {
		getComboBox().setMaximumRowCount(num);
	}
	public static VirtualComboBox virtualComboBox (JComboBox theComboBox) {	
		return (VirtualComboBox) AWTComponent.virtualComponent(theComboBox);		
			
	}
	public Object getSelectedItem() {
		return getComboBox().getSelectedItem();
	}
	public void setSelectedItem(Object choice) {
		 getComboBox().setSelectedItem(choice);
	}
	public void addItem(Object choice) {
		 getComboBox().addItem(choice);
	}
	
	

}
