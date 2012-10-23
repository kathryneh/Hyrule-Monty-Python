package avatars;

public class AlignedTalkingGuard extends TalkingGuardAvatar implements Talkable {
	
	public AlignedTalkingGuard(int x, int y, String element) {
		super(x, y, element);
	}

	@Override
	public void buildTalkingAvatar(int x, int y, String element){
		avatar = new avatars.GuardAvatar(x, y, element);
		chat = new chat.AlignedChatHistory(x, y-50/*, element*/);
	}
}
