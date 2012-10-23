package avatars;

public class AlignedTalkingKnight extends TalkingKnightAvatar implements
		Talkable {
	public AlignedTalkingKnight(int x, int y, String element) {
		super(x, y, element);
	}
	
	@Override 
	public void buildTalkingAvatar(int x, int y, String element){
		avatar = new avatars.KnightAvatar(x, y);
		chat = new chat.AlignedChatHistory(x, y-50, element);
	}

}
