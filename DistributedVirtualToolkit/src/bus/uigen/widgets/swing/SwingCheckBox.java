package bus.uigen.widgets.swing;

import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;

import bus.uigen.widgets.VirtualCheckBox;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingCheckBox extends SwingComponent implements VirtualCheckBox {
	//JCheckBox getJCheckBox();
	public SwingCheckBox (JCheckBox theCheckBox) {
		super (theCheckBox);
		//getJCheckBox() = theCheckBox;	
		
	}
	public SwingCheckBox() {
		
	}
	public JCheckBox getJCheckBox() {
		return (JCheckBox) component;
	}
	public boolean isSelected() {
		return getJCheckBox().isSelected();
	}
	public void setSelected (boolean newVal) {
		getJCheckBox().setSelected(newVal);
	}
	public void addChangeListener (ChangeListener l) {
		getJCheckBox().addChangeListener(l);
	}
	public void addChangeListener (Object l) {
		addChangeListener ((ChangeListener)l);
		//getJCheckBox().addChangeListener(l);
	}
	public void postEvent(Event event) {
		getJCheckBox().postEvent(event);
	}
	public void addActionListener (ActionListener theListener) {
		addActionListener(theListener);
		
	}
	public void addActionListener (Object theListener) {
		addActionListener((ActionListener) theListener);		
	}
	public void addItemListener (ItemListener theListener) {
		getJCheckBox().addItemListener(theListener);
		//addActionListener(theListener);
		
	}
	@SuppressWarnings("deprecation")
	public void setLabel (String newValue) {
		getJCheckBox().setLabel(newValue);
	}
	@SuppressWarnings("deprecation")
	public String getLabel() {
		return getJCheckBox().getLabel();
		
	}
	public void addItemListener (Object theListener) {
		addActionListener((ItemListener) theListener);		
	}
	
	public static SwingCheckBox virtualCheckBox (JCheckBox theCheckBox) {	
		return (SwingCheckBox) AWTComponent.virtualComponent(theCheckBox);		
			
	}
	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
