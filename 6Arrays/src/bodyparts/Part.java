package bodyparts;

import main.Line;
import main.Oval;
import main.Rectangle;

public interface Part {
	public int getStartX();

	public int getStartY();

	public void setStartX(int newX);

	public void setStartY(int newY);

	// public void setWidth();
	// public void setHeight();
	// public int getWidth();
	// public int getHeight();
	public Line getLinePart();

	public Oval getOvalPart();

	public Rectangle getRectanglePart();

}
