package parts;

public abstract class Part{
	protected int x,y;
	public void scrollH(int n){
		x-=n;
	}
	public void scrollV(int n){
		y-=n;
	}
}
