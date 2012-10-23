package graphics;

public class RotatingLine extends Line implements RotatingShapes{
	double hyp;
	public RotatingLine(int w,int h,Points p){
		super(w,h,p);
		hyp=Math.sqrt((h*h)+(w*w));
	}
	@Override
	public void rotate() {
		rotate(Math.PI/4);
	}
	@Override
	public void rotate(double r) {
		double foo=0;
		if(w==0){
			if(h<0)
				foo=-Math.PI/2;
			if(h>0)
				foo=Math.PI/2;
		}
		else
			foo=Math.atan(-(double)h/w);
		if(w<=0){
			foo+=Math.PI;
		}
		h=-(int)((double)hyp*Math.sin(foo+r));
		w=(int)((double)hyp*Math.cos(foo+r));
	}
	@Override
	public void rotateTo(double r) {
		h=-(int)(hyp*Math.sin(r));
		w=(int)(hyp*Math.cos(r));
	}
	public void move(Point p){
		super.p=p;
	}
}
