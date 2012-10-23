package avatars;

import chat.chatHistory;

public class TalkingKnightAvatar implements TalkingAvatar {
	private KnightAvatar knight;
	private chatHistory chat;
	private int x;
	private int y;

	public void setX(int newVal) {
		x = newVal;
		knight.setX(newVal);
		chat.setX(x);
	}
	public void setChatY(int i){
		chat.setY(i);
	}
	
	public void setY(int newVal) {
		y = newVal;
		knight.setY(newVal);
		chat.setY(y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	//public GuardAvatar getGuardAvatar(){
	//	return null;
	//}

	public TalkingKnightAvatar(int x, int y, String element) {
		String text = element;
		knight = new avatars.KnightAvatar(x, y);
		chat = new chat.chatHistory(x-75, y - 60, text);
		setX(x);
		setY(y);
		getKnightAvatar();
		getChatHistory();
	}

	public KnightAvatar getKnightAvatar() {
		return knight;
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