package graphics;

public class ASetYCommand implements Runnable{
	
	ObservedGraphic graphic;
	int newY;
	int steps;
	int pauseTime;

	public ASetYCommand(ObservedGraphic graphic, int newY, int steps, int pauseTime){
		this.graphic=graphic;
		this.newY=newY;
		this.steps=steps;
		this.pauseTime=pauseTime;
	}
	
	public void run() {
		/// One line which calls the correct animate method on line with the correct parameters.
		graphic.animateSetY(newY, steps, pauseTime);
	}

}

