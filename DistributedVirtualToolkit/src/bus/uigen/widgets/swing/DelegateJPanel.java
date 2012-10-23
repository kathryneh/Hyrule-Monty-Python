package bus.uigen.widgets.swing;

import java.awt.Graphics;

import bus.uigen.widgets.Painter;

import javax.swing.JPanel;

import java.util.Vector;

public class DelegateJPanel extends JPanel /*implements VirtualDelegatePanel */
{
   
	private static final long serialVersionUID = 1L;
	
	public DelegateJPanel ()
    {
        super();
        
    }
   
    Vector<Painter> painters = new Vector<Painter>();
	public void addPainter(Painter painter) {
		if (painters.contains(painter))
			return;
		painters.add(painter);
		
		
	}
	public void removePainter(Painter painter) {
		if (painters.contains(painter))
			return;
		painters.remove(painter);		
		
	}
    public void paint(Graphics g)
    {
    	super.paint(g);
    	for (int i = 0; i < painters.size(); i++)
    		painters.elementAt(i).paint(g);    		
    	
    }
    


}