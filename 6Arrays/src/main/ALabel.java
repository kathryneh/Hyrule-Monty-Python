package main;

public class ALabel implements Label {
	int newX;
	int newY;
	int newWidth;
	int newHeight;
	String newString;
	String newImg;

	public ALabel(int x, int y, int width, int height, String text, String img) {

		newX = x;
		newY = y;
		newWidth = width;
		newHeight = height;
		newString = text;
		newImg = img;

		setWidth(newWidth);
		setHeight(newHeight);
		setText(newString);
		setImageFileName(newImg);
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
		// TODO Auto-generated method stub
		return newWidth;
	}


	@Override
	public void setWidth(int newWidth) {
		this.newWidth = newWidth;

	}

	@Override

	public int getHeight() {
		return newHeight;
	}


	@Override
	public void setHeight(int newHeight) {
		this.newHeight = newHeight;

	}

	@Override
	public String getText() {
		return newString;
	}


	@Override
	public void setText(String newString) {
		this.newString = newString;

	}


	@Override
	public String getImageFileName() {
		return newImg;
	}


	@Override
	public void setImageFileName(String newImg) {
		this.newImg = newImg;

	}

}
