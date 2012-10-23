package bodyparts;

import util.annotations.Visible;
import main.Line;
import main.Oval;
import main.Rectangle;

public class Sword implements Part {
	int startX;
	int startY;
	int newHeight;
	int newWidth;
	Line sword;

	public Sword(int x, int y, int width, int height) {
		startX = x;
		startY = y;
		newHeight = height;
		newWidth = width;
		sword = new main.ALine(startX, startY, newWidth, newHeight);
	}

	public Line getSword() {
		return sword;
	}


	@Override
	public int getStartX() {
		// TODO Auto-generated method stub
		return sword.getX();
	}


	@Override
	public int getStartY() {
		// TODO Auto-generated method stub
		return sword.getY();
	}


	@Override
	public void setStartX(int newX) {
		sword.setX(newX);
	}

	@Override
	public void setStartY(int newY) {
		sword.setY(newY);
	}

	@Override
	public Line getLinePart() {
		return sword;
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