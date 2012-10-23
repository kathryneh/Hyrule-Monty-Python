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
	public static boolean animate = false;


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

	public synchronized void KnightCrossBridge(){
		System.out.println("Knight Cross Bridge Attempt");
		if (knightAnsweredQuestions>=KNIGHT_ANSWERS_TO_PASS || (!(guardAvatar.getX() == 385))){
			if (!getAnimation()){
				smartKnightAvatarCollection.pushCrossed(knightAvatarCollection.leadingKnight());
				knightAvatarCollection.removeElement();
			}
			else{
				smartKnightAvatarCollection.pushAnimatedCrossed(knightAvatarCollection.leadingKnight());
				knightAvatarCollection.removeAnimatedElement();
			}
			smartKnightAvatarCollection.pushCrossed(knightAvatarCollection.leadingKnight());
			knightAvatarCollection.removeElement();
			knightAnsweredQuestions = 0;
		}
		else{
			speakTalkingGuard("You shall not pass!");
		}
	}


	public synchronized void KnightFallOffCliff(){
		AlignedTalkingKnight fallenAvatar = knightAvatarCollection.leadingKnight();
		System.out.println(fallenAvatar.getName() +" " + fallenAvatar.getType() + fallenAvatar.getChatHistory() + " " + fallenAvatar.getX() + " " + fallenAvatar.getY());
		if (!getAnimation()){
		knightAvatarCollection.removeElement();
		fallenCollection.pushFallen(fallenAvatar);
		}
		else{
			knightAvatarCollection.removeAnimatedElement();
			fallenCollection.pushAnimatedFallen(fallenAvatar);
		}
		
		knightAnsweredQuestions = 0; //reset the # of questions back to 0. 
	}
	@Override
	public void guardFallOffCliff() {
		AlignedTalkingGuard guard = getGuardAvatar();
		if (!getAnimation()){
		fallenCollection.pushFallenGuard(guard);
		}
		else{
			fallenCollection.PushAnimatedFallenGuard(guard);
		}

	}

	public synchronized void moveTalkingGuardX(int x){
		guardAvatar.moveX(x);
	}
	public synchronized void moveTalkingGuardY(int y){
		guardAvatar.moveY(y);
	}
	public synchronized void moveKnightAvatarCollectionX(int x){
		System.out.println("animate =" + getAnimation());
		if (knightAvatarCollection.size() > 0){
			if (knightAvatarCollection.getX()+x < guardAvatar.getX()){
				if (getAnimation() == false){
					System.out.println(this);
					knightAvatarCollection.moveX(x);
					System.out.println("animations are off for move command" + animate);
				}
				else{
					knightAvatarCollection.moveAnimatedX(x);
					System.out.println("animations are on for move command"+ animate);
				}
			}
			else{
			}
		}
		else {
			smartKnightAvatarCollection.moveX(x);
		}

	}
	public synchronized void moveKnightAvatarCollectionY(int y){
		System.out.println("animate =" + getAnimation());
		if (getAnimation()==false){
		knightAvatarCollection.moveY(y);
		System.out.println("animations are off for move command");
		}
		else{
			knightAvatarCollection.moveAnimatedY(y);
			System.out.println("animations are on for move command");
		}
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
	public void setAnimation(){
		if(animate){
			animate = false;
		}
		else{
			animate = true;
		}
		System.out.println("animate =" + getAnimation());
	}

	public boolean getAnimation(){
		return animate;
	}
}
