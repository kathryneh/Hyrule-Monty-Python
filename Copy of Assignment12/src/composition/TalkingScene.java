package composition;


import util.annotations.Visible;
import util.models.VectorChangeEvent;
import avatars.AvatarCollectable;
import chat.YLocation;
import avatars.AlignedTalkingKnight;
import avatars.Collectable;
import avatars.FallenCollection;
import avatars.ObservableAlignedSpacedCollection;
import avatars.Talkable;
import avatars.AlignedTalkingGuard;
import avatars.AlignedSpacedCollection;

@SuppressWarnings("unused")
public class TalkingScene extends Scene implements TalkingScenic{

	private static final int KNIGHT_ANSWERS_TO_PASS = 3;
	protected int knightAnsweredQuestions = 0;
	protected int speaker = 2;
	private AlignedTalkingGuard guardAvatar;
	private AlignedSpacedCollection smartKnightAvatarCollection;
	private AlignedSpacedCollection knightAvatarCollection;
	private FallenCollection fallenCollection;


	public TalkingScene(){
		guardAvatar = new avatars.AlignedTalkingGuard(385, 250, "Mido");

		smartKnightAvatarCollection = new avatars.AlignedSpacedCollection(675, 290);

		knightAvatarCollection = new avatars.AlignedSpacedCollection(285, 250);
		knightAvatarCollection.push("Bob");
		knightAvatarCollection.push("Link");
		knightAvatarCollection.push("Joe");

		fallenCollection = new avatars.FallenCollection(550, 550);


	}
	@Override
	public AlignedTalkingGuard getGuardAvatar() {
		return guardAvatar;
	}


	public void KnightCrossBridge(){
		System.out.println("Knight Cross Bridge Attempt");
		if (knightAnsweredQuestions>=KNIGHT_ANSWERS_TO_PASS || (!(guardAvatar.getX() == 385))){
			smartKnightAvatarCollection.pushCrossed(knightAvatarCollection.leadingKnight());
			knightAvatarCollection.removeElement();
			knightAnsweredQuestions = 0;
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
		
		knightAnsweredQuestions = 0; //reset the # of questions back to 0. 
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
		if (knightAvatarCollection.size() > 0){
			if (knightAvatarCollection.getX()+x < guardAvatar.getX()){
				knightAvatarCollection.moveX(x);
			}
			else{
			}
		}
		else {
			smartKnightAvatarCollection.moveX(x);
		}

	}
	public void moveKnightAvatarCollectionY(int y){
		knightAvatarCollection.moveY(y);
	}

	public void speakAvatars(String text){
		int knightX = knightAvatarCollection.getX();
		System.out.println("knight position" + knightX);
		if (( knightX < 325 && knightX > 245)|| (knightX <50 && knightX>-50)){
			if (speaker%2 == 0){
				speakTalkingGuard(text);
				speaker++;
			}
			else if ((speaker%2) == 1){
				speakKnightAvatar(text);
				questionAnsweredCorrectly();
				speaker++;
			}
		}
		else System.out.println("Knight not in standing area.");
	}
	public void questionAnsweredCorrectly(){
		knightAnsweredQuestions++;
	}

	public void speakTalkingGuard(String text){
		guardAvatar.push(0, YLocation.getYChatLocation(), text);
	}
	public void speakKnightAvatar(String text){
		knightAvatarCollection.speakKnightAvatar(0, YLocation.getYChatLocation(), text);
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
	public void turnOnAnimation(){
		graphics.Animation.turnOnAnimation();
	}

	public void turnOffAnimation(){
		graphics.Animation.turnOffAnimation();
	}
}
