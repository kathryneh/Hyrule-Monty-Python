package avatar;

import graphics.Oval;
import graphics.Point;
import graphics.RotatingLine;
import graphics.RotatingShapes;
import graphics.Shapes;


public class Rotatable extends Basic implements Rotatables {
	RotatingShapes b,a[],l[];
	Shapes h;
	public Rotatable(Point l){
		super(l);
		this.b=new RotatingLine(0,32,new Point(l.getX()+23,l.getY()+32));
		this.h=new Oval(26,32,new Point(l.getX()+10,l.getY()));
		this.a=new RotatingShapes[]{new RotatingLine(-14,32,new Point(l.getX()+23,l.getY()+32)),new RotatingLine(14,32,new Point(l.getX()+23,l.getY()+32))};
		this.l=new RotatingShapes[]{new RotatingLine(18,40,new Point(l.getX()+23,l.getY()+62)),new RotatingLine(-18,40,new Point(l.getX()+23,l.getY()+62))};
	}
	public RotatingShapes getBody() {
		return b;
	}
	@Override
	public RotatingShapes[] getArms(){
		return a;
	}
	@Override
	public RotatingShapes[] getLegs(){
		return l;
	}
	@Override
	public void rotateC(){
		rotate(-Math.PI/8);
	}
	@Override
	public void rotateCC(){
		rotate(Math.PI/8);
	}
	@Override
	public void rotate(double r){
		double foo=0;
		b.rotate(r);
		for(int i=0;i<2;i++){
			a[i].rotate(r);
			l[i].rotate(r);
		}
		if(b.getHeight()==0){
			if(b.getWidth()<0)
				foo=Math.PI/2;
			if(b.getWidth()>0)
				foo=-Math.PI/2;
		}
		else
			foo=Math.atan((double)b.getWidth()/b.getHeight());
		if(b.getHeight()<=0){
			foo+=Math.PI;
		}
		Point o=new Point(
				(13*16)/Math.sqrt(Math.pow(16*Math.cos(-foo+Math.PI/2),2)+Math.pow(13*Math.sin(-foo+Math.PI/2),2))*Math.cos(-foo+Math.PI/2),
				(13*16)/Math.sqrt(Math.pow(16*Math.cos(-foo+Math.PI/2),2)+Math.pow(13*Math.sin(-foo+Math.PI/2),2))*Math.sin(-foo+Math.PI/2));
		b.move(new Point(super.l.getX()+23+o.getX(),super.l.getY()+16+o.getY()));
		for(int i=0;i<2;i++){
			a[i].move(new Point(super.l.getX()+23+o.getX(),super.l.getY()+16+o.getY()));
			l[i].move(new Point(b.getWidth()+b.getLocation().getX(),b.getHeight()+b.getLocation().getY()));
		}
	}
}
