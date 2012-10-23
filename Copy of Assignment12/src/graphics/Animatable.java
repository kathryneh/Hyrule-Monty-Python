package graphics;

public interface Animatable {
	public void setX(int newX);
	public void setY(int newY);
	public void animateSetX(int newX);
	public void animateSetY(int newY);
	public void sleep (int pauseTime);
	public void animateSetX(int newX, int steps, int pauseTime);
	public void animateSetY(int newY, int steps, int pauseTime);
}
