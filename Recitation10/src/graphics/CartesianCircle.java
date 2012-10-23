package graphics;

/**
 * A resizable circle in Cartesian space.
 * DO NOT EDIT THIS CLASS IN RECITATION.
 * Feel free to edit this class if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public class CartesianCircle extends CartesianOval implements Circle {

	public CartesianCircle(int x, int y, int radius) {
		super(x, y, 2 * radius, 2 * radius);
	}
	
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
	public void setHeight(int height) {
		super.setWidth(height);
		super.setHeight(height);
	}
	
	public int getRadius() {
		return super.getWidth() / 2;
	}
	
	public void setRadius(int radius) {
		super.setWidth(2 * radius);
		super.setHeight(2 * radius);
	}
}