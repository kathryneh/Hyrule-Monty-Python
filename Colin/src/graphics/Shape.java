package graphics;

public abstract class Shape implements Shapes{
	int h,w;
	Points p;
	public Shape(int w,int h,Points p){
		this.h=h;
		this.w=w;
		this.p=p;
	}
	@Override
	public int getHeight() {
		return h;
	}
	@Override
	public Points getLocation() {
		return p;
	}
	@Override
	public int getWidth() {
		return w;
	}	
}
