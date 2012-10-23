package avatars;

import chat.chatHistory;

public interface TalkingAvatar {
	public void setX(int x);
	public void setY(int y);
	public int getX();
	public int getY();
	//public GuardAvatar getGuardAvatar();
	public KnightAvatar getKnightAvatar();
	public chatHistory getChatHistory();
	public void pop();
	public void push(String element);
	public void removeElement();
	public void moveX(int x);
	public void moveY(int y);
}
