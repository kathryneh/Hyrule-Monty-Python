package composition;

import avatars.Collectable;
import avatars.TalkingGuardAvatar;

public interface TalkingScenic extends Scenic {
	
	public TalkingGuardAvatar getGuardAvatar();
	
	public Collectable getKnightAvatarCollection();
	
	public Collectable getSmartKnightAvatarCollection();
	
	public void speakTalkingGuard(String text);
	
	public void speakKnightAvatar(String element);
	public void moveTalkingGuardY(int y);
	public void moveTalkingGuardX(int x);
	public void moveKnightAvatarCollectionY(int y);
	public void moveKnightAvatarCollectionX(int x);
}
