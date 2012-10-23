package main;

public class AnOval implements Oval {
	int newX;
	int newY;
	int newWidth;
	int newHeight;

	public AnOval(int x, int y, int width, int height) {
		newX = x;
		newY = y;
		newWidth = width;
		newHeight = height;
	}

	@Override

	public int getX() {
		return newX;
	}

	@Override

	public void setX(int newX) {
		this.newX = newX;
	}

	@Override

	public int getY() {
		return newY;
	}


	@Override
	public void setY(int newY) {
		this.newY = newY;
	}

	@Override
	public int getWidth() {
		return newWidth;
	}

	@Override
	public void setWidth(int newVal) {
		newWidth = newVal;
	}

	
	@Override
	public int getHeight() {
		return newHeight;
	}

	@Override
	public void setHeight(int newHeight) {
		this.newHeight = newHeight;
	}

}
