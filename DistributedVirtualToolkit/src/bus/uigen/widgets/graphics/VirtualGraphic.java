package bus.uigen.widgets.graphics;

//import java.awt.Graphics;
import org.eclipse.swt.events.PaintListener;

public abstract class VirtualGraphic /*extends Graphics*/implements PaintListener{
	
	public abstract void addDrawnObject(VirtualGraphicObject o);
	
}