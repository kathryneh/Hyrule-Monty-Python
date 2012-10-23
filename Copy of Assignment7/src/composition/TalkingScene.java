package composition;


import avatars.KnightCollection;
import avatars.TalkingGuardAvatar;

public class TalkingScene extends Scene implements TalkingScenic{

	private TalkingGuardAvatar guardAvatar;
	private KnightCollection smartKnightAvatarCollection;
	private KnightCollection knightAvatarCollection;
	
	public TalkingScene(){
		guardAvatar = new avatars.TalkingGuardAvatar(150, 125, "Give me liberty,");
	/*	
		smartKnightAvatarCollection = new avatars.KnightCollection(385, 55);
		smartKnightAvatarCollection.push("There is no spoon, Neo.");
		smartKnightAvatarCollection.push("Use the force, Luke!");
		
		knightAvatarCollection = new avatars.KnightCollection(190, 30);
		knightAvatarCollection.push("or give you death?");
		knightAvatarCollection.push("That would be quite convenient.");
		knightAvatarCollection.push("Shopping is fun!");
		*/	
	}
	@Override
	public TalkingGuardAvatar getGuardAvatar() {
		return guardAvatar;
	}

	public KnightCollection getKnightAvatarCollection() {
		return knightAvatarCollection;
	}

	public KnightCollection getSmartKnightAvatarCollection() {
		return smartKnightAvatarCollection;
	}

}
