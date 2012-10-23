package composition;

import avatars.AvatarCollectable;
import avatars.Collectable;
import avatars.TalkingGuardAvatar;

public interface TalkingScenic extends Scenic {
	public TalkingGuardAvatar getGuardAvatar();
	public void KnightCrossBridge();
	public void KnightFallOffCliff();
	public AvatarCollectable getKnightAvatarCollection();
	public Collectable getSmartKnightAvatarCollection();
	public void speakTalkingGuard(String text);
	public void speakKnightAvatar(String element);
	public void moveTalkingGuardY(int y);
	public void moveTalkingGuardX(int x);
	public void speakAvatars(String text);
	public void moveKnightAvatarCollectionY(int y);
	public void moveKnightAvatarCollectionX(int x);
	public Collectable getFallenCollection();
	public void guardFallOffCliff();
}
