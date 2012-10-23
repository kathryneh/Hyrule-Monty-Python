package graphics;


/**
 * A line segment in 2-dimensional Cartesian space.
 * DO NOT EDIT THIS CLASS IN RECITATION.
 * Feel free to edit this class if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public class CartesianLine extends ResizableCartesianShape implements Line {
	
	
	public CartesianLine(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void setX(int x) {
		super.setX(x);
	}
	
	public void setY(int y) {
		super.setY(y);
	}
	
	public void animateSetX(int newX){
		//Create a new ASetXCommand instance and a new thread then start the thread.
		Runnable animateCommand = new ASetXCommand(this, newX, 10, 100);
		Thread thread = new Thread(animateCommand);
		thread.setName("Set X Animation");
		thread.start();
	}
	
	public void animateSetY(int newY){
		//create a new ASetYCommand and a new Thread and then start the thread.
		Runnable animateCommand = new ASetYCommand(this, newY, 10, 100);
		Thread thread = new Thread(animateCommand);
		thread.setName("Set Y Animation");
		thread.start();
	}
	
	public synchronized void animateSetX(int newX, int steps, int pauseTime){
		//get the old value and then create a loop which goes through "steps" steps
		// calculate a current x value, calling this.setX on the new current value 
		// then call sleep.
		int oldX = getX();
		int currentX = oldX;
		System.out.println("OldX: " + oldX);
		double dX = (newX)/steps;
		System.out.println("dX:" + dX);
		for (int i = 0; i < steps; i++){
			currentX += dX;
			this.setX(currentX);
			sleep(pauseTime);
		}
		
	}
	
	public synchronized void animateSetY(int newY, int steps, int pauseTime){
		int oldY = getY();
		int currentY = oldY;
		double dY = (newY)/steps;
		for (int i = 0; i<steps; i++){
			currentY+=dY;
			this.setY(currentY);
			sleep(pauseTime);
		}
	}
	
	public void sleep(int pauseTime) {
		try {
			// OS suspends program for pauseTime
			Thread.sleep(pauseTime);
		} catch (InterruptedException e) {
			// program may be forcibly interrupted while sleeping
			e.printStackTrace();
		}
	}
	
}