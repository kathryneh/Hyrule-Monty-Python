package avatar;

import equipment.Label;
import equipment.Labels;
import graphics.Point;

public class Named extends Basic implements Nameds{
	String n;
	public Named(Point l,String n) {
		super(l);
		this.n=n;
	}
	public Labels getLabel() {
		return new Label(new Point(l.getX()+2,l.getY()+106),n);
	}
}
