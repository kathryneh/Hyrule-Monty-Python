package graphics;

public class Label extends Graphic implements Labelable {
	protected String img;
	
	public Label(int x, int y, int width, int height, String newImg) {
		super(x, y, width, height);
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
