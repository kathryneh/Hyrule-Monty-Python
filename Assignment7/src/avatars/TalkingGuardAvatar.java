package avatars;

import chat.ChatHistory;


public class TalkingGuardAvatar implements Talkable {
	GuardAvatar avatar;
	ChatHistory chat;
	int x;
	int y;
	
	public void setX(int newVal) {
		x = newVal;
		avatar.setX(x);
		chat.setX(x);
	}
	
	public void setY(int newVal) {
		y = newVal;
		avatar.setY(y);
		chat.setY(y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public TalkingGuardAvatar(int x, int y, String element) {
		buildTalkingAvatar(x, y, element);
		setX(x);
		setY(y);
	}
	
	public GuardAvatar getAvatar(){
		return avatar;
	}

	public ChatHistory getChatHistory() {
		return chat;
	}

	public void pop() {
		chat.pop();
	}

	public void push(int x, int y, String element) {
		chat.push(x, y, element);
	}

	public void removeElement() {
		chat.removeElement();
	}

	public void moveX(int newX) {
		x = x + newX;
		setX(x);
		chat.moveX(newX);
		
	}
	public void moveY(int newY) {
		y = y + newY;
		setY(y);
		chat.moveY(newY);
	}

	@Override
	public void buildTalkingAvatar(int x, int y, String element) {
		avatar = new avatars.GuardAvatar(x, y);
		chat = new chat.ChatHistory(x, y, element);
	}

}
