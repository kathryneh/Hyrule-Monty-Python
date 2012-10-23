package avatars;

import chat.ChatHistory;

public interface Talkable {
	public void setX(int newVal);
	public void setY(int newVal);
	public void moveX(int newVal);
	public void moveY(int newVal);
	public int getX();
	public int getY();
	public Avatar getAvatar();
	public ChatHistory getChatHistory();
	public void pop();
	public void push(int x, int y, String element);
	public void removeElement();
	public void buildTalkingAvatar(int x, int y, String element);
}
