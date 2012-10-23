package avatar;

import graphics.Line;
import graphics.Oval;
import graphics.Point;
import graphics.Shapes;

public abstract class Basic implements Avatars {
	Point l;
	public Basic(Point l){
		this.l=l;
	}
	@Override
	public Shapes getBody() {
		return new Line(0,32,new Point(l.getX()+23,l.getY()+32));
	}
	@Override
	public Shapes getHead() {
		return new Oval(26,32,new Point(l.getX()+10,l.getY()));
	}
	@Override
	public Shapes[] getArms(){
		return new Shapes[]{new Line(-14,32,new Point(l.getX()+23,l.getY()+32)),new Line(14,32,new Point(l.getX()+23,l.getY()+32))};
	}
	@Override
	public Shapes[] getLegs() {
		return new Shapes[]{new Line(18,40,new Point(l.getX()+23,l.getY()+62)),new Line(-18,40,new Point(l.getX()+23,l.getY()+62))};
	}
}
