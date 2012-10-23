package graphics;

public class Text extends ObservedGraphic implements Textable {
	protected String text;
	
	public Text(int x, int y, int width, int height, String newText) {
		super(x, y, width, height);
		text = newText;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String newString) {
		text = newString;
	}



}
