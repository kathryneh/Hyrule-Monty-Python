package bodyparts;

import util.annotations.Visible;
import main.Line;
import main.Oval;
import main.Rectangle;

public class Ovals implements Part {
	int startX;
	int startY;
	int newHeight;
	int newWidth;
	Oval oval;

	public Ovals(int x, int y, int width, int height) {
		startX = x;
		startY = y;
		newHeight = height;
		newWidth = width;
		oval = new main.AnOval(startX, startY, newWidth, newHeight);
	}

	public Oval getOval() {
		return oval;
	}


	@Override
	public int getStartX() {
		// TODO Auto-generated method stub
		return oval.getX();
	}


	@Override
	public int getStartY() {
		// TODO Auto-generated method stub
		return oval.getY();
	}


	@Override
	public void setStartX(int newX) {
		oval.setX(newX);
	}


	@Override
	public void setStartY(int newY) {
		oval.setY(newY);
	}


	@Override
	@Visible(false)
	public Line getLinePart() {
		return null;
	}

	@Override
	public Oval getOvalPart() {
		// TODO Auto-generated method stub
		return oval;
	}

	@Override
	@Visible(false)
	public Rectangle getRectanglePart() {
		// TODO Auto-generated method stub
		return null;
	}
}