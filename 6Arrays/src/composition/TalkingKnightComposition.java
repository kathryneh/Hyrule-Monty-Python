package composition;

import main.Oval;
import scenery.BridgeScenery;
import avatars.KnightAvatarCollection;
import avatars.OvalStandingArea;
import avatars.TalkingGuardAvatar;

public class TalkingKnightComposition implements TalkingComposition{
	private BridgeScenery bridge;
	//private OvalStandingArea KnightStandingArea;
	//private OvalStandingArea GuardStandingArea;
	private Oval GSA;
	private Oval KSA;
	private TalkingGuardAvatar guardAvatar;
	private KnightAvatarCollection smartKnightAvatarCollection;
	private KnightAvatarCollection knightAvatarCollection;
	
	public TalkingKnightComposition(){
		bridge = new scenery.BridgeScenery(0, 0);
		OvalStandingArea GuardStandingArea = new avatars.OvalStandingArea(385, 250);
		GSA = GuardStandingArea.standingArea();
		OvalStandingArea KnightStandingArea = new avatars.OvalStandingArea(285, 250);
		KSA = KnightStandingArea.standingArea();
		guardAvatar = new avatars.TalkingGuardAvatar(150, 125, "Give me liberty,");
		
		smartKnightAvatarCollection = new avatars.KnightAvatarCollection(385, 55);
		smartKnightAvatarCollection.push("There is no spoon, Neo.");
		smartKnightAvatarCollection.push("Use the force, Luke!");
		
		knightAvatarCollection = new avatars.KnightAvatarCollection(190, 30);
		knightAvatarCollection.push("or give you death?");
		knightAvatarCollection.push("That would be quite convenient.");
		knightAvatarCollection.push("Shopping is fun!");
			
	}
	@Override
	public BridgeScenery getBridge() {
		return bridge;
	}

	@Override
	public TalkingGuardAvatar getGuardAvatar() {
		return guardAvatar;
	}

	@Override
	public KnightAvatarCollection getKnightAvatarCollection() {
		return knightAvatarCollection;
	}
	public Oval getKnightStandingArea() {
		return KSA;
	}
	
	public Oval getGuardStandingArea() {
		return GSA;
	}

	public KnightAvatarCollection getSmartKnightAvatarCollection() {
		return smartKnightAvatarCollection;
	}

}
