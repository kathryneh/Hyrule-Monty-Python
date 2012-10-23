package bus.uigen.widgets.swing;

import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JMenuItem;

import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.universal.AUniversalWidget;

public class SwingMenuItem extends AUniversalWidget implements VirtualMenuItem {
	//MenuItem menuItem;
	public SwingMenuItem (JMenuItem theMenuItem) {
		super (theMenuItem);
		//menuItem = theMenuItem;
	}
	public SwingMenuItem () {
		
	}
	public Component getPhysicalComponent() {
		return (Component) component;
		
	}
	
	VirtualMenuContainer parent;
	public void setParent (VirtualMenuContainer theParent) {
		parent = theParent;		
		
	}
	public VirtualMenuContainer getParent() {
		return parent;
		//return (VirtualMenu) AUniversalWidget.universalWidget(menuComponent.getParent());
	}
	public JMenuItem getMenuItem() {
		return (JMenuItem) component;
	}
	public void setEnabled (boolean newVal) {
		getMenuItem().setEnabled(newVal);
	}
	public void enable () {
		setEnabled(true);
	}
	public void postEvent(Event event) {
		getMenuItem().postEvent(event);
	}
	public void setLabel (String newVal) {
		getMenuItem().setLabel(newVal);
	}
	public void addActionListener (Object theListener) {
		addActionListener((ActionListener) theListener);
		
	}
	public void setToolTipText(String s) {
		if (getMenuItem() instanceof JComponent)
			((JComponent) getMenuItem()).setToolTipText(s);
	}
	public void setFont(Font f) {
		getMenuItem().setFont(f);
	}
	public Font getFont() {
		return getMenuItem().getFont();
	}
	
	public void setActionCommand (String cmd) {
		getMenuItem().setActionCommand(cmd);
	}
	public void addActionListener (ActionListener theListener) {
		getMenuItem().addActionListener(theListener);
		
	}
	public static SwingMenuItem virtualMenuItem (JMenuItem theMenuItem) {
		return (SwingMenuItem) AUniversalWidget.universalWidget(theMenuItem);
	}
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
	}

}
