package avatars;

public interface AvatarCollectable extends Collectable {

	public void moveX(int x);
	public void moveY(int y);
	public void speakKnightAvatar(int x, int y, String element);
	public void pushFallen(AlignedTalkingKnight avatar);
	public void pushCrossed(AlignedTalkingKnight avatar);
}
