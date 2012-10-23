package graphics;

public class Label extends Text implements Labelable {
	String img;
	
	public Label(int x, int y, int width, int height, String text, String newImg) {
		super(x, y, width, height, text);
		img = newImg;
	}

	@Override
	public String getImageFileName() {
		return img;
	}

	@Override
	public void setImageFileName(String newVal) {
		img = newVal;
	}



}
