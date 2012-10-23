package avatars;

import graphics.Rectangle;

public class GuardAvatar extends Avatar implements GuardAvatarized {
	protected Rectangle shield;
	public GuardAvatar(int x, int y, String name) {
		super(x, y, name);
	}

	public Rectangle getShield() {
		return shield;
	}
	
	@Override
	public void buildAvatar(){
		this.shield = new graphics.Rectangle(xValue + armLength, yValue+10
				+ (headHeight * 2 - armLength), 36, 38);
		super.buildAvatar();
	}

}
