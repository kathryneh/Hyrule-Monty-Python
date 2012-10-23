package equipment;

import graphics.Line;
import graphics.Point;
import graphics.Shapes;

public class Sword extends Equipment implements Equipments{
	public Sword(Point l,boolean a) {
		super(l,a);
	}
	public Shapes[] getSword(){
		if(a)
			return new Shapes[]{new Line(35,-70,new Point(l.getX()+34,l.getY()+72)),new Line(12,6,new Point(l.getX()+35,l.getY()+55))};
		else
			return new Shapes[]{new Line(35,-70,new Point(l.getX()+34+7,l.getY()+72-4)),new Line(12,6,new Point(l.getX()+35+7,l.getY()+55-4))};
	}

}
