package main;

public class ATextBox implements TextBox {
	int X;
	int Y;
	int width;
	int height;
	String text;

	public ATextBox(int x, int y, int width, int height, String text) {
		X = x;
		Y = y;
		this.width = width;
		this.height = height;
		this.text = text;
	}

	@Override
	public int getX() {
		return X;
	}

	@Override
	public void setX(int newVal) {
		X = newVal;

	}

	@Override
	public int getY() {
		return Y;
	}

	@Override
	public void setY(int newVal) {
		Y = newVal;
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
	public void setHeight(int newVal) {
		height = newVal;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String newVal) {
		text = newVal;

	}

}
