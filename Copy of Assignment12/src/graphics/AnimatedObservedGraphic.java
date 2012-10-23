package graphics;

public class AnimatedObservedGraphic extends ObservedGraphic {

	public AnimatedObservedGraphic(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void setX(int newX){
		//this method determines if animation (boolean)is turned on. If it is, it will animate any move
		//if it is not, it will call the normal setX method (renamed to setUnanimatedX)
		System.out.println("Animation is " + Animation.isAnimated());
		if (Animation.isAnimated()){
			super.setUnanimatedX(newX);
			System.out.println("Animation is off. Unanimated movements");
			System.out.println(Animation.isAnimated());
		}
		else{
			super.animateSetX(newX);
		}
	}
	
	public void setY(int newY){
		if (!Animation.isAnimated()){
			super.setUnanimatedY(newY);
		}
		else{
			super.animateSetY(newY);
		}
	}
	
}
