package composition;


import util.annotations.Visible;
import avatars.AvatarCollectable;
import chat.YLocation;
import avatars.AlignedTalkingKnight;
import avatars.Collectable;
import avatars.FallenCollection;
import avatars.Talkable;
import avatars.AlignedTalkingGuard;
import avatars.AlignedSpacedCollection;

@SuppressWarnings("unused")
public class TalkingScene extends Scene implements TalkingScenic{
	
	protected int numAnswered = 0;
	protected int speaker = 2;
	private AlignedTalkingGuard guardAvatar;
	private AlignedSpacedCollection smartKnightAvatarCollection;
	private AlignedSpacedCollection knightAvatarCollection;
	private FallenCollection fallenCollection;
	
	
	public TalkingScene(){
		guardAvatar = new avatars.AlignedTalkingGuard(385, 250, "Mido");

		smartKnightAvatarCollection = new avatars.AlignedSpacedCollection(675, 290);
		//smartKnightAvatarCollection.push(0, 0, "Bob", null);
		//smartKnightAvatarCollection.push(0, 0, "Joe", null);
		
		knightAvatarCollection = new avatars.AlignedSpacedCollection(285, 250);
		knightAvatarCollection.push(0, 0, "Bob", "knight");
		knightAvatarCollection.push(0, 0, "Link", "knight");
		knightAvatarCollection.push(0, 0, "Joe", "knight");
		
		fallenCollection = new avatars.FallenCollection(550, 550);
		
	
	}
	@Override
	public AlignedTalkingGuard getGuardAvatar() {
		return guardAvatar;
	}
	
	
	public void KnightCrossBridge(){
		if (numAnswered>3 || (!(guardAvatar.getX() == 385))){
			smartKnightAvatarCollection.pushCrossed(knightAvatarCollection.leadingKnight());
			knightAvatarCollection.removeElement();
			//smartKnightAvatarCollection.push(0, 0, "Bob", "knight");
		}
		else{
			speakTalkingGuard("You shall not pass!");
		}
	}
	
	
	public void KnightFallOffCliff(){
		AlignedTalkingKnight fallenAvatar = knightAvatarCollection.leadingKnight();
		System.out.println(fallenAvatar.getName() +" " + fallenAvatar.getType() + fallenAvatar.getChatHistory() + " " + fallenAvatar.getX() + " " + fallenAvatar.getY());
		knightAvatarCollection.removeElement();
		fallenCollection.pushFallen(fallenAvatar);
		//fallenCollection.push(0,0, "Bob", "knight");
	}
	@Override
	public void guardFallOffCliff() {
		AlignedTalkingGuard guard = getGuardAvatar();
		fallenCollection.pushFallenGuard(guard);
		
	}
	
	
	
	public void moveTalkingGuardX(int x){
		guardAvatar.moveX(x);
	}
	public void moveTalkingGuardY(int y){
		guardAvatar.moveY(y);
	}
	public void moveKnightAvatarCollectionX(int x){
		knightAvatarCollection.moveX(x);
	}
	public void moveKnightAvatarCollectionY(int y){
		knightAvatarCollection.moveY(y);
	}
	
	public void speakAvatars(String text){
		if (speaker%2 == 0){
			speakTalkingGuard(text);
			speaker++;
		}
		else if ((speaker%2) == 1){
			speakKnightAvatar(text);
			speaker++;
		}
	}
	
	public void speakTalkingGuard(String text){
		guardAvatar.push(0, YLocation.getYChatLocation(), text);
	}
	public void speakKnightAvatar(String text){
		int knightX = knightAvatarCollection.getX();
		if ( knightX == 285){
		knightAvatarCollection.speakKnightAvatar(0, YLocation.getYChatLocation(), text);
		}
		else {
			speakTalkingGuard("Get back in your spot!");
		}
	}

	public AvatarCollectable getKnightAvatarCollection() {
		return knightAvatarCollection;
	}
	
	public Collectable getFallenCollection(){
		return fallenCollection;
	}

	public AvatarCollectable getSmartKnightAvatarCollection() {
		return smartKnightAvatarCollection;
	}

	//(a) ensure that the leading knight cannot cross the bridge unless 
	//three questions have been answered or the guard has moved away from 
	//its standing area,
	//for this, need to use a counter to keep track of the number of correct questions
	//need to do a test to see if the guard is in the standing area (for x direction only)
	//need to do this if the move x value is positive and the get x is greater than or equal to the 
	// knight standing area
	
	
	//(b) a knight can speak only if it is in the knight standing area 
	//do a test to see if the knightcollection[0] get x and get y are where they should be.
	
	//(c) the leading knight and guard alternate speaking.
	//change to one method rather than two; use the mod function to determine which will speak

}
