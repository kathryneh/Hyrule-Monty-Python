package graphics;

public class ASetXCommand implements Runnable{
	
	ObservedGraphic graphic;
	int newX;
	int steps;
	int pauseTime;

	public ASetXCommand(ObservedGraphic graphic, int newX, int steps, int pauseTime){
		this.graphic=graphic;
		this.newX=newX;
		this.steps=steps;
		this.pauseTime=pauseTime;
	}
	
	public void run() {
		/// One line which calls the correct animation method on line.
		graphic.animateSetX(newX, steps, pauseTime);
	}

}
