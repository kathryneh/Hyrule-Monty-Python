package equipment;

import graphics.Points;

public class Label implements Labels{
	Points p;
	String t;
	public Label(Points p, String t){
		this.p=p;
		this.t=t;
	}
	@Override
	public String getText() {
		return t;
	}
	@Override
	public int getHeight() {
		return 17;
	}
	@Override
	public Points getLocation() {
		return p;
	}
	@Override
	public int getWidth() {
		if(t==null)
			return 1;
		return(int)Math.ceil(8.7*t.length());
	}
}