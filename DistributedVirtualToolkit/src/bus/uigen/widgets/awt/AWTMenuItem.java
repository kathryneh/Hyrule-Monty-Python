package bus.uigen.widgets.awt;

import java.awt.Event;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionListener;

import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.universal.AUniversalWidget;

public class AWTMenuItem extends AWTMenuComponent implements VirtualMenuItem {
	//MenuItem menuItem;
	public AWTMenuItem (MenuItem theMenuItem) {
		super (theMenuItem);
		//menuItem = theMenuItem;
	}
	public AWTMenuItem () {
		
	}
	public MenuItem getMenuItem() {
		return (MenuItem) component;
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
	public void setActionCommand (String cmd) {
		getMenuItem().setActionCommand(cmd);
	}
	public void addActionListener (ActionListener theListener) {
		getMenuItem().addActionListener(theListener);
		
	}
	public void setToolTipText(String s) {
		
	}
	public void setFont(Font f) {
		getMenuItem().setFont(f);
	}
	public Font getFont() {
		return getMenuItem().getFont();
	}
	public static AWTMenuItem virtualMenuItem (MenuItem theMenuItem) {
		return (AWTMenuItem) AUniversalWidget.universalWidget(theMenuItem);
	}
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
		
	}

}
