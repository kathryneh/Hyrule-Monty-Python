package bodyparts;

import util.annotations.Visible;
import main.Line;
import main.Oval;
import main.Rectangle;

public class Shield implements Part {
	int startX;
	int startY;
	int newHeight;
	int newWidth;
	Rectangle shield;

	public Shield(int x, int y, int width, int height) {
		startX = x;
		startY = y;
		newHeight = height;
		newWidth = width;
		shield = new main.ARectangle(startX, startY, newWidth, newHeight);
	}

	public Rectangle getRectangle() {
		return shield;
	}


	@Override
	public int getStartX() {
		// TODO Auto-generated method stub
		return shield.getX();
	}


	@Override
	public int getStartY() {
		// TODO Auto-generated method stub
		return shield.getY();
	}


	@Override
	public void setStartX(int newX) {
		shield.setX(newX);
	}


	@Override
	public void setStartY(int newY) {
		shield.setY(newY);
	}

	@Override
	@Visible(false)
	public Line getLinePart() {
		return null;
	}

	@Override
	@Visible(false)
	public Oval getOvalPart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRectanglePart() {
		// TODO Auto-generated method stub
		return shield;
	}
}
