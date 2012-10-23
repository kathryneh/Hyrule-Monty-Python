package bodyparts;

import util.annotations.Visible;
import main.Line;
import main.Oval;
import main.Rectangle;
import main.TextBox;

public class Name implements Part {
	int startX;
	int startY;
	int newHeight;
	int newWidth;
	TextBox name;

	public Name(int x, int y, int width, int height, String text) {
		startX = x;
		startY = y;
		newHeight = height;
		newWidth = width;
		name = new main.ATextBox(startX, startY, newWidth, newHeight, text);
	}

	public TextBox getName() {
		return name;
	}


	@Override
	public int getStartX() {
		// TODO Auto-generated method stub
		return name.getX();
	}

	@Override

	public int getStartY() {
		// TODO Auto-generated method stub
		return name.getY();
	}

	@Override

	public void setStartX(int newX) {
		name.setX(newX);
	}

	@Override
	public void setStartY(int newY) {
		name.setY(newY);
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
	@Visible(false)
	public Rectangle getRectanglePart() {
		// TODO Auto-generated method stub
		return null;
	}

	public TextBox getNamePart() {
		return name;
	}
}