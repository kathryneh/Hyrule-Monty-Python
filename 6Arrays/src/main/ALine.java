package main;

public class ALine implements Line {
	int x, y, width, height;

	public ALine(int initX, int initY, int initWidth, int initHeight) {
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int newX) {
		x = newX;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int newY) {
		y = newY;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int newVal) {
		width = newVal;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int newHeight) {
		height = newHeight;
	}
}
