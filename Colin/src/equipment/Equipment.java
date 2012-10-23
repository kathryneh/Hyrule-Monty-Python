package equipment;

import graphics.Point;

public abstract class Equipment implements Equipments {
	Point l;
	boolean a;
	public Equipment(Point l,boolean a) {
		this.l=l;
		this.a=a;
	}
}
