package avatar;

import equipment.Equipments;
import equipment.Sheild;
import graphics.Point;

public class NamedMovableGuard extends NamedMovable implements NamedMovables {
	boolean a=true;
	public NamedMovableGuard(Point l,String n) {
		super(l,n);
	}
	public Equipments getSheild(){
		return new Sheild(super.l,a);
	}
//	public void move(){
//		super.move();
//		a=!a;//pose command w/the help of the modified getArms()getLegs() methods
//	}
}