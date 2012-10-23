package graphics;

public class Point implements Points{
	int x,y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public Point(double x,double y){
		this.x=(int) x;
		this.y=(int) y;
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
}
