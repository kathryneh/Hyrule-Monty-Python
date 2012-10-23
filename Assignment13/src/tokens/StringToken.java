package tokens;

import composition.TalkingScene;

public class StringToken extends Token implements Tokenizable {
	TalkingScene scene;
	String input;
	public StringToken(String input) {
		super(input);
		setDescription("Quoted String");
	}
	public StringToken(String input, TalkingScene s) {
		super(input);
		setDescription("QuotedString");
		scene = s;
		this.input = input;
		setStringValue(input);
		takeTokenAction();
	}
	
	void takeTokenAction() {
		scene.speakAvatars(input);		
	}
}
