package chat;

public class YLocation {
static int b =225;;
	public YLocation(){
		b = 225;
	}
	public static int getYChatLocation() {
		b -= 25;
		return b;
	}
	public static void setYChatLocation(int y){
		b = y;
	}

}
