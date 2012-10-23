package avatars;

import graphics.Line;

public class KnightAvatar extends Avatar implements KnightAvatarized {
	protected Line sword;
	
	public KnightAvatar(int x, int y, String name) {
		super(x, y, name);
	}

	public Line getSword() {
		return sword;
	}

	@Override
	public void buildAvatar(){
		this.sword = new graphics.Line(xValue + armLength, yValue
				+ headHeight * 2 + armLength, 36, -38);	
		super.buildAvatar();
	}
	@Override
	public void setX(int newX){
		super.setX(newX);
		sword.setX(xValue+armLength);
//		System.out.println("KnightAvatar setX called");
	}
	@Override
	public void setY(int newY){
		super.setY(newY);
		sword.setY(yValue
				+ headHeight * 2 + armLength);
	}
	public void setAnimatedX(int newX){
		super.setAnimatedX(newX);
		sword.setAnimatedX(xValue+armLength);
//		System.out.println("KnightAvatar setX called");
	}
	@Override
	public void setAnimatedY(int newY){
		super.setAnimatedY(newY);
		sword.setAnimatedY(yValue
				+ headHeight * 2 + armLength);
	}
}
