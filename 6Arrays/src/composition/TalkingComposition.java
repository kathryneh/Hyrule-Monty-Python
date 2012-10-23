package composition;

import avatars.KnightAvatarCollection;
import avatars.TalkingGuardAvatar;
import main.Oval;
import scenery.BridgeScenery;

public interface TalkingComposition {
	public BridgeScenery getBridge();

	public Oval getKnightStandingArea();
	
	public Oval getGuardStandingArea();
	
	public TalkingGuardAvatar getGuardAvatar();
	
	public KnightAvatarCollection getKnightAvatarCollection();
	
	public KnightAvatarCollection getSmartKnightAvatarCollection();
}
