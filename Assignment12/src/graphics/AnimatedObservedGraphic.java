package graphics;

public class AnimatedObservedGraphic extends ObservedGraphic {

	public AnimatedObservedGraphic(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void setX(int newX){
			super.setUnanimatedX(newX);
			
	
	}
	
	public void setY(int newY){
			super.setUnanimatedY(newY);
			
	}
	
	public void setAnimatedX(int newX){
		super.animateSetX(newX);
	}
	public void setAnimatedY(int newY){
		super.animateSetY(newY);
	}
	
}
