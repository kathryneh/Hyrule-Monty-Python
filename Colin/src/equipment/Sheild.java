package equipment;

//import graphics.Line;
import graphics.Oval;
import graphics.Point;
import graphics.Shapes;

public class Sheild extends Equipment implements Equipments{
	public Sheild(Point l,boolean a) {
		super(l,a);
	}
	public Shapes getSheild(){
		if(a)
			return new Oval(32,48,new Point(l.getX()+22,l.getY()+40));
		else
			return new Oval(32,48,new Point(l.getX()+15,l.getY()+44));
	}
}