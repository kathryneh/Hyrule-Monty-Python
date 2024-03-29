package bus.uigen.widgets.awt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.border.Border;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;
import bus.uigen.widgets.graphics.VirtualGraphic;
import bus.uigen.widgets.universal.AUniversalWidget;

public abstract class AWTComponent extends AUniversalWidget implements VirtualComponent {
	//Component component;
	String ID;
	
	Vector<VirtualFocusListener> vFocusListeners = new Vector<VirtualFocusListener>();
	Vector<VirtualMouseListener> vMouseListeners = new Vector<VirtualMouseListener>();
	Vector<VirtualMouseMoveListener> vMouseMoveListeners = new Vector<VirtualMouseMoveListener>();
	
	VirtualContainer parent;
	public AWTComponent (Component theComponent) {
		super (theComponent);
		//component = theComponent;
		
	}
	
	
	public AWTComponent () {
		
		
		
	}
	public Component getComponent() {
		return (Component) component;
		
	}
	
	public void init(){
		AWTComponentEventForwarder forwarder = new AWTComponentEventForwarder(this);
		getComponent().addFocusListener(forwarder);
		getComponent().addMouseListener(forwarder);
		getComponent().addMouseMotionListener(forwarder);
	}
	
	public void init (Component theComponent) {
		super.init(theComponent);
	}
	
	public Vector<VirtualMouseMoveListener> getVirtualMouseMoveListener(){
		return vMouseMoveListeners;
	}
	
	public Vector<VirtualMouseListener> getVirtualMouseListeners(){
		return vMouseListeners;
	}
	
	public Vector<VirtualFocusListener> getVirtualFocusListeners(){
		return vFocusListeners;
	}
	/*
	public void init (Object theComponent) {
		init ((Component) theComponent);
	}
	*/
	public void setParent (VirtualContainer theParent) {
		parent = theParent;
	}
	public VirtualContainer getParent () {
		if (parent != null)
		return parent;
		if (getComponent().getParent() == null)
			return null;
		return AWTContainer.virtualContainer(getComponent().getParent());
	}
	public void addToParent (VirtualContainer theParent) {
		theParent.add(this);
	}
	public void invalidate() {
		 getComponent().invalidate();
	}
	public void setVisible (boolean newVal) {
		getComponent().setVisible(newVal);
	}
	public String getName() {
		return getComponent().getName();
	}
	public void setName (String newVal) {
		getComponent().setName(newVal);
	}
	public Object getPhysicalComponent() {
		return getComponent();
	}
	public Component getAWTComponent() {
		return getComponent();
	}
	public void doLayout() {
		getComponent().doLayout();
	}
	public void setLocation(int newX, int newY) {
		 getComponent().setLocation(newX, newY);
	}
	public void setLocation(Point newVal) {
		getComponent().setLocation(newVal);
	}
	
	public void repaint() {
		getComponent().repaint();
	}
	public void validate() {
		
		getComponent().validate();
	}
	public void revalidate() {
	if (getComponent() instanceof JComponent)
		((JComponent) getComponent()).revalidate();
	else
		getComponent().validate();
	}
	
	public void setBackground(Object newVal) {
		getComponent().setBackground((Color) newVal);
	}
	public void setBackground(Color newVal) {
		getComponent().setBackground(newVal);
	}
	public Object getBackground() {
		return getComponent().getBackground();
	}
	
	/*public void addMouseListener (Object mouseListener) {
		getComponent().addMouseListener((MouseListener) mouseListener);
	}*/
	public void setEnabled (boolean newVal) {
		getComponent().setEnabled(newVal);
	}
	public void setMaximumSize(Dimension d) {
		getComponent().setMaximumSize(d);
	}
	public void setMinimumSize(Dimension d) {
		getComponent().setMinimumSize(d);
	}
	public void setSize(Dimension d) {
		getComponent().setSize(d);
	}
	public void setSize (int width, int height) {
		execSetSize(width, height);
		if(VirtualToolkit.isDistributed()){
			String widgetID = this.getID();
			String uniqueID = VirtualToolkit.getUniqueID();
			VirtualToolkit.sendCommand(COMMAND_LABEL + widgetID +SET_SIZE_COMMAND + uniqueID + "," + width +"," + height +")");
		}
	}
	
	public void execSetSize(int width, int height){
		getComponent().setSize(width, height);		
	}
	
	public void setPreferredSize (Dimension d) {
		getComponent().setPreferredSize(d);
	}
	@SuppressWarnings("deprecation")
	public void resize (int width, int height) {
		getComponent().resize(width, height);
	}
	public Dimension getSize() {
		return getComponent().getSize();
	}
	public int getHeight() {
		return getComponent().getHeight();
	}
	public int getWidth() {
		return getComponent().getWidth();
	}
	public Dimension getMinimumSize() {
		return getComponent().getMinimumSize();
	}
	public Dimension getPreferredSize() {
		return getComponent().getMinimumSize();
	}
	public void setCursor(Object newVal) {
		getComponent().setCursor((Cursor) newVal);
	}
	public void setCursor(Cursor newVal) {
		getComponent().setCursor(newVal);
	}
	public void setCursor (int newVal) {
		
	}
	
	public boolean isVisible () {
		return getComponent().isVisible();
	}
	public void setBorder (Object border) {
		if (getComponent() instanceof JComponent)
			((JComponent) getComponent()).setBorder((Border) border);
	}
	public void setBorder (Border border) {
		if (getComponent() instanceof JComponent)
			((JComponent) getComponent()).setBorder( border);
	}
	public void setAlignmentX (float x) {
		if (getComponent() instanceof JComponent)
			((JComponent) getComponent()).setAlignmentX( x);
	}
	public void setAlignmentY (float y) {
		if (getComponent() instanceof JComponent)
			((JComponent) getComponent()).setAlignmentY( y);
	}
	public void setToolTipText(String s) {
		if (getComponent() instanceof JComponent)
			((JComponent) getComponent()).setToolTipText(s);
	}
	public void addKeyListener(Object listener) {
		getComponent().addKeyListener((KeyListener) listener);		
	}
	public void addKeyListener(KeyListener listener) {
		getComponent().addKeyListener( listener);		
	}
	/*
	static transient Hashtable<Component, VirtualComponent> componentsToVirtualComponents = new Hashtable();
	static transient Hashtable<Class, Class> componentClassToVirtualComponentClass = new Hashtable();
	public static VirtualComponent existingVirtualComponent (Component c) {
		return componentsToVirtualComponents.get(c);
		
	}
	public static void register (Component c, VirtualComponent vc) {
		componentsToVirtualComponents.put(c, vc);
	}
	public static Class getVirtualClass(Class c) {
		//return AUniversalWidget.getVirtualClass(c);
		
		Class virtualClass = componentClassToVirtualComponentClass.get(c);
		Class superClass = c.getSuperclass();
		if (virtualClass != null) return virtualClass;
		else if (superClass != null) return getVirtualClass (superClass);
		else return null;
		
	}
	
	*/
	public static VirtualComponent virtualComponent (Component c) {
		return (VirtualComponent) AUniversalWidget.universalWidget(c);
		/*
		if (c == null) return null;
		VirtualComponent vc = componentsToVirtualComponents.get(c);
		if (vc == null) {
			try {
			//Class virtualClass = componentClassToVirtualComponentClass.get(c.getClass());
			Class virtualClass = getVirtualClass(c.getClass());
			if (virtualClass == null) vc = new AnAWTComponent(c);
			else {
				 vc = (VirtualComponent) virtualClass.newInstance();
				vc.init(c);
			}
			
			} catch (Exception e) {
				vc = new AnAWTComponent(c);
			}
			componentsToVirtualComponents.put(c, vc);	
			
					
		}
			
		return vc;
		*/
			
	}
	/*
	public static void register (Class componentClass, Class virtualClass) {
		componentClassToVirtualComponentClass.put(componentClass, virtualClass);
	}
	public static void registerVirtualComponentClasses() {
		register (Component.class, AnAWTComponent.class);
		register (Container.class, AnAWTContainer.class);
		register (Frame.class, AnAWTFrame.class);
		//register (JPanel.class, ASwingPanel.class);
		register (JLabel.class, ASwingLabel.class);
		register (JToolBar.class, ASwingToolBar.class);
		register (JFrame.class, ASwingFrame.class);
		register (JTextField.class, ASwingTextField.class);
		register (JTextArea.class, ASwingTextArea.class);
		register (JButton.class, ASwingButton.class);
		register (JSlider.class, ASwingSlider.class);
		register (JComboBox.class, ASwingComboBox.class);
		register (JPasswordField.class, ASwingPasswordField.class);
		register (JRadioButton.class, ASwingRadioButton.class);
		register (JSlider.class, ASwingSlider.class);
		register (JSplitPane.class, ASwingSplitPane.class);
		register (JTabbedPane.class, ASwingTabbedPane.class);
		register (JTree.class, ASwingTree.class);
		register (JTable.class, ASwingTable.class);
		
	}
	*/
	//@Override
	public void setBounds(int newX, int newY, int newWidth, int newHeight) {
		// TODO Auto-generated method stub
		
	}
	
	public void setFont(Font f) {
		getComponent().setFont(f);
	}
	
	public Font getFont() {
		return getComponent().getFont();
	}
	
	public void addMouseListener(VirtualMouseListener listener){
		vMouseListeners.add(listener);
	}
	
	public void addMouseTrackListener(VirtualMouseListener listener){
		addMouseListener(listener);
	}
	
	public void addMouseMoveListener(VirtualMouseMoveListener listener){
		vMouseMoveListeners.add(listener);
	}
	
	public void addFocusListener(VirtualFocusListener listener){
		vFocusListeners.add(listener);
	}
	
	
	@Override
	public void pack() {
		// TODO Auto-generated method stub
		
	}
	
	public void addPaintListener(VirtualGraphic g) {
	
	}


	@Override
	public void addPaintListener(Object g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeFocusListener(Object Listener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeMouseMoveListener(Object listener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setMinimumSize(Object d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPreferredSize(Object d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSize(Object d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeMouseListener(Object Listener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setLocation(Object newVal) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setMaximumSize(Object d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isDisposed(){
		return true;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}
	
	
}
