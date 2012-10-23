package graphics;

public class Animation {
	public static int numSteps = 10;
	public static int amountPauseTime = 100;
	public static boolean animate = false;
	
	public Animation(){
		animate = isAnimated();
	}
	
	public static boolean isAnimated(){
		return animate;
	}
	public static void turnOnAnimation(){
		//setAnimate(true);
		animate = true;
		System.out.println("Turning on animation" + isAnimated());
	}

	public static void turnOffAnimation(){
		//setAnimate(false);
		animate = false;
		System.out.println("Turning off animation" + isAnimated());
	}

	public static void setAnimate(boolean b) {
		animate = b;
		System.out.println("Animate = " + isAnimated());
	}
	public static void setNumSteps(int newNum){
		numSteps = newNum;
	}

	public static void setAmountPauseTime(int newNum){
		amountPauseTime = newNum;
	}
}
