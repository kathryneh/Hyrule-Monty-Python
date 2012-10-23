package graphics;

public interface RotatingShapes extends Shapes{
	public void rotate();
	public void rotate(double r);
	public void rotateTo(double r);
	public void move(Point point);
}
