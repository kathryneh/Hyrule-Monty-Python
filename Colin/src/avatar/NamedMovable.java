package avatar;

import graphics.Line;
import graphics.Point;
import graphics.Shapes;

public abstract class NamedMovable extends Named implements NamedMovables {
	boolean a=true;
	Shapes[] ar, le;
	public NamedMovable(Point l,String n){
		super(l,n);
		ar=getArms();
		le=getLegs();
	}
	@Override
	public void move(){
		moveH(15);
		a=!a;//pose command w/the help of the modified getArms()getLegs() methods
	}
	public void moveH(int n){
		super.l=new Point(super.l.getX()+n,super.l.getY());
	}
	public void moveV(int n){
		super.l=new Point(super.l.getX(),super.l.getY()+n);
	}
	@Override
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
