package bodyparts;

import util.annotations.Visible;
import main.Line;
import main.Oval;
import main.Rectangle;

public class Leg implements Part {
	int startX;
	int startY;
	int newHeight;
	int newWidth;
	Line leg;

	public Leg(int x, int y, int width, int height) {
		startX = x;
		startY = y;
		newHeight = height;
		newWidth = width;
		leg = new main.ALine(startX, startY, newWidth, newHeight);
	}

	public Line getLeg() {
		return leg;
	}

	@Override
	public int getStartX() {
		// TODO Auto-generated method stub
		return leg.getX();
	}

	@Override
	public int getStartY() {
		// TODO Auto-generated method stub
		return leg.getY();
	}

	@Override
	public void setStartX(int newX) {
		leg.setX(newX);
	}

	@Override
	public void setStartY(int newY) {
		leg.setY(newY);
	}

	@Override
	public Line getLinePart() {
		return leg;
	}

	@Override
	@Visible(false)
	public Oval getOvalPart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Visible(false)
	public Rectangle getRectanglePart() {
		// TODO Auto-generated method stub
		return null;
	}
}