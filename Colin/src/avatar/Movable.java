package avatar;

import graphics.Point;

public class Movable extends Basic implements Avatars{

	public Movable(Point l) {
		super(l);
	}
	public void move(){
		super.l=new Point(super.l.getX()+10,super.l.getY());
	}
//	public int getX(){
//		return super.l.getX();
//	}
//	public int getY(){
//		return super.l.getY();
//	}
//	public void setX(int x){
//		super.l=new Point(x,super.l.getY());
//	}
//	public void setY(int y){
//		super.l=new Point(super.l.getX(),y);
//	}
}
