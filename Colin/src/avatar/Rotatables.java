package avatar;

import graphics.RotatingShapes;
import graphics.Shapes;

public interface Rotatables extends Avatars{
	public Shapes getHead();
	public Shapes getBody();
	public RotatingShapes[] getArms();
	public RotatingShapes[] getLegs();
	public void rotateC();
	public void rotateCC();
	public void rotate(double r);
}
