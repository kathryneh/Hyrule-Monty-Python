package composition;

import avatars.KnightAvatar;

public class KnightScene extends Scene implements KnightScenic{
	private KnightAvatar knight;
	
	public KnightScene(){
		super();
		knight = new avatars.KnightAvatar(285, 250);
		getKnight();
	}
	
	public KnightAvatar getKnight() {
		// avatars.KnightAvatar knight = new avatars.KnightAvatar(0, 50);
		return knight;
	}
}
