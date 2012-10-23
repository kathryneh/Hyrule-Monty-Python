package graphics;

/**
 * A graphics object in Cartesian space that possesses
 * an upper left corner and a bounding box
 * whose dimensions can be resized.
 * DO NOT EDIT THIS CLASS IN RECITATION.
 * Feel free to edit this class if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public abstract class ResizableCartesianShape extends CartesianShape implements ResizableShape {

	protected ResizableCartesianShape() {
		super();
	}
	
	protected ResizableCartesianShape(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
}