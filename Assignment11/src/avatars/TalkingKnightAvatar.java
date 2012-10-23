package avatars;

import chat.AlignedChatHistory;


public abstract class TalkingKnightAvatar implements Talkable {
	protected KnightAvatar avatar;
	protected AlignedChatHistory chat;
	private int x;
	private int y;
	protected String name;
	//String type;
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getName(){
		return name;
	}
	//public void setType(String newType){
	//	type = newType;
	//}
	public String getType(){
		return "knight";
	}
	
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
	
	public TalkingKnightAvatar(int x, int y, String element) {
		buildTalkingAvatar(x, y, element);
		setX(x);
		setY(y);
		setName(element);
	}
	
	public void setChatX(int x){
		chat.moveX(x);
	}
	public void setChatY(int y){
		chat.moveY(y);
	}
	
	
//	public void buildTalkingAvatar(int x, int y, String name){
//		avatar = new avatars.KnightAvatar(x, y, name);
//		chat = new chat.AlignedChatHistory(x, y);
//	}
	
	public KnightAvatar getAvatar(){
		return avatar;
	}

	public AlignedChatHistory getChatHistory() {
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
	@Override
	public void moveX(int newX) {
		x = x + newX;
		setX(x);
		chat.moveX(newX);
		System.out.println("TalkingKnightAvatar moveX called");
		
	}
	@Override
	public void moveY(int newY) {
		y = y + newY;
		setY(y);
		chat.moveY(newY);
	}

}
