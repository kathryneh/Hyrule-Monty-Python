package avatar;

import equipment.Equipments;
import equipment.Sword;
import graphics.Point;

public class NamedMovableKnight extends NamedMovable implements NamedMovables{
	boolean a=true;
	public NamedMovableKnight(Point l,String n) {
		super(l,n);
	}
	public Equipments getSword(){
		return new Sword(super.l,a);
	}
	public void move(){
		super.move();
		a=!a;//pose command w/the help of the modified getArms()getLegs() methods
	}
}
