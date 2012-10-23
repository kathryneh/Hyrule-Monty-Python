package avatar;

import graphics.Line;
import graphics.Point;
import graphics.Shapes;


public class Poseable extends Basic implements Avatars {
	boolean a=true;
	Shapes[] arms, legs;
	public Poseable(Point l){
		super(l);
		arms=getArms();
		legs=getLegs();
	}
	public void pose(){a=!a;}
	public Shapes[] getArms(){
		if(a){
			return super.getArms();	
		}
		else{
			return new Shapes[]{new Line(-21,28,new Point(super.l.getX()+23,super.l.getY()+32)),new Line(21,28,new Point(super.l.getX()+23,super.l.getY()+32))};
		}
	}
	@Override
	public Shapes[] getLegs() {
		if(a){
			return super.getLegs();
		}
		else{
			return new Shapes[]{new Line(26,35,new Point(super.l.getX()+23,super.l.getY()+62)),new Line(-26,35,new Point(super.l.getX()+23,super.l.getY()+62))};
		}
	}
}
