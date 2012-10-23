package graphics;

/**
 * A resizable square in Cartesian space.
 * DO NOT EDIT THIS CLASS IN RECITATION.
 * Feel free to edit this class if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public class CartesianSquare extends CartesianRectangle implements Square {

	public CartesianSquare(int x, int y, int side) {
		super(x, y, side, side);
	}
	
	public void setWidth(int width) {
		setSide(width);
	}
	
	public void setHeight(int height) {
		setSide(height);
	}
	
	public int getSide() {
		return super.getWidth();
	}
	
	public void setSide(int side) {
		super.setWidth(side);
		super.setHeight(side);
	}
}