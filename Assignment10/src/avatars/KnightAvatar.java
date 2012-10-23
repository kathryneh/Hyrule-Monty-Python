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

}
