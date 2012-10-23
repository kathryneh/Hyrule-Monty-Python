package graphics;

public class ASetYCommand implements Runnable{
	
	Line line;
	int newY;
	int steps;
	int pauseTime;

	public ASetYCommand(Line line, int newY, int steps, int pauseTime){
		this.line=line;
		this.newY=newY;
		this.steps=steps;
		this.pauseTime=pauseTime;
	}
	
	public void run() {
		/// One line which calls the correct animate method on line with the correct parameters.
		line.animateSetY(newY, steps, pauseTime);
	}

}
