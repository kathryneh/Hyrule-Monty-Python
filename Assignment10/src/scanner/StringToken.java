package scanner;

import composition.TalkingScene;

public class StringToken extends Token implements Tokenizable {
	public StringToken(String input) {
		super(input);
		setDescription("Quoted String");
	}

	void takeTokenAction(TalkingScene scene, String text) {
		scene.speakAvatars(text);		
	}
}
