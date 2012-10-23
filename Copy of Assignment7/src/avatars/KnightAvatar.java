package avatars;

import graphics.Line;

public class KnightAvatar extends Avatar implements KnightAvatarized {
	Line sword;
	
	public KnightAvatar(int x, int y) {
		super(x, y);
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
