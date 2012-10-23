package bodyparts;

import util.annotations.Visible;
import main.Line;
import main.Oval;
import main.Rectangle;

public class Arm implements Part {
	// int startX;
	// int startY;
	// int newHeight;
	// int newWidth;
	Line arm;

	public Arm(int x, int y, int width, int height) {
		// newHeight = height;
		// newWidth = width;
		arm = new main.ALine(x, y, width, height);
	}

	public Line getLeftArm() {
		return arm;
	}

	public int getStartX() {
		// TODO Auto-generated method stub
		return arm.getX();
	}


	public int getStartY() {
		// TODO Auto-generated method stub
		return arm.getY();
	}

	public void setStartX(int newX) {
		arm.setX(newX);
	}


	public void setStartY(int newY) {
		arm.setY(newY);
	}


	public Line getLinePart() {
		return arm;
	}


	@Visible(false)
	public Oval getOvalPart() {
		// TODO Auto-generated method stub
		return null;
	}


	@Visible(false)
	public Rectangle getRectanglePart() {
		// TODO Auto-generated method stub
		return null;
	}

}
