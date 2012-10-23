package graphics;

public class ASetXCommand implements Runnable{
	
	Line line;
	int newX;
	int steps;
	int pauseTime;

	public ASetXCommand(Line line, int newX, int steps, int pauseTime){
		this.line=line;
		this.newX=newX;
		this.steps=steps;
		this.pauseTime=pauseTime;
	}
	
	public void run() {
		/// One line which calls the correct animation method on line.
		line.animateSetX(newX, steps, pauseTime);
	}

}
