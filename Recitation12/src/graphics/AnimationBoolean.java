package graphics;

public class AnimationBoolean {
static boolean animate;

public boolean isAnimated(){
	return animate;
}
public void turnOnAnimation(){
	animate = true;
}

public void turnOffAnimation(){
	animate = false;
}
}
