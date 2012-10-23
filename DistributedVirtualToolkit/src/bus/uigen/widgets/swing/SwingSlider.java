package bus.uigen.widgets.swing;

import java.awt.Event;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import bus.uigen.widgets.VirtualSlider;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingSlider extends AWTComponent implements VirtualSlider {
	//JSlider slider;
	public SwingSlider (JSlider theSlider) {
		super (theSlider);
		//slider = theSlider;	
		
	}
	public JSlider getSlider() {
		return (JSlider) component;
	}
	public SwingSlider() {
		
	}
	public void setValue(int value) {
		getSlider().setValue(value);
	}
	public int getValue() {
		return getSlider().getValue();
	}
	public void setValueIsAdjusting (boolean newVal) {
		getSlider().setValueIsAdjusting(newVal);
	}
	public void addChangeListener (ChangeListener l) {
		getSlider().addChangeListener(l);
	}
	public void addChangeListener (Object l) {
		addChangeListener ((ChangeListener)l);
		//getSlider().addChangeListener(l);
	}
	public void postEvent(Event event) {
		getSlider().postEvent(event);
	}
	public void addActionListener (ActionListener theListener) {
		System.out.println("Action listener not allowed on slider");
		//addActionListener(theListener);
		
	}
	public void addActionListener (Object theListener) {
		System.out.println("Action listener not allowed on slider");
		//addActionListener((ActionListener) theListener);		
	}
	public void setModel(BoundedRangeModel m) {
		getSlider().setModel(m);
	}
	public void updateUI() {
		getSlider().updateUI();
	}
	
	public static SwingSlider virtualSlider (JSlider theSlider) {	
		return (SwingSlider) AWTComponent.virtualComponent(theSlider);		
			
	}
	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setModel(Object m) {
		// TODO Auto-generated method stub
		
	}
	

	
	

}
