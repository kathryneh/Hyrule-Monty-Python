package avatars;

public abstract class TalkingGuardAvatar2 extends TalkingAvatar{
	GuardAvatar avatar;
	public TalkingGuardAvatar2(int x, int y, String element) {
		super(x, y, element);
	}
	public void setX(int newVal) {
		x = newVal;
		avatar.setX(x);
		chat.setX(x);
	}
	
	public void setY(int newVal) {
		y = newVal;
		avatar.setY(y);
		chat.setY(y);
	}
	
	public void setAnimatedX(int newVal) {
		x = newVal;
		avatar.setAnimatedX(x);
		chat.setAnimatedX(x);
	}
	
	public void setAnimatedY(int newVal) {
		y = newVal;
		avatar.setAnimatedY(y);
		chat.setAnimatedY(y);
	}
	public Avatar getAvatar(){
		return avatar;
	}

}
