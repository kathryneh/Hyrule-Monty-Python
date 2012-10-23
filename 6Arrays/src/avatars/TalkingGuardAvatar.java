package avatars;

import chat.chatHistory;

public class TalkingGuardAvatar implements TalkingAvatar {
	private GuardAvatar guard;
	private chatHistory chat;
	private int x;
	private int y;

	public void setX(int newVal) {
		x = newVal;
		guard.setX(newVal);
		chat.setX(x);
	}

	public void setY(int newVal) {
		y = newVal;
		guard.setY(newVal);
		chat.setY(y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public TalkingGuardAvatar(int x, int y, String element) {
		String text = element;
		guard = new avatars.GuardAvatar(x, y);
		chat = new chat.chatHistory(x, y - 50, text);
		setX(x);
		setY(y);
		getGuardAvatar();
		getChatHistory();
	}

	public GuardAvatar getGuardAvatar() {
		return guard;
	}
	
	public KnightAvatar getKnightAvatar(){
		return null;
	}

	public chatHistory getChatHistory() {
		return chat;
	}

	public void pop() {
		chat.pop();
	}

	public void push(String element) {
		chat.push(element);
	}

	public void removeElement() {
		chat.removeElement();
	}

	@Override
	public void moveX(int x) {
		setX(x);
		
	}

	@Override
	public void moveY(int y) {
		setY(y);
		
	}

}