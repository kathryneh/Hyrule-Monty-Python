package scanner;

import composition.TalkingScene;

public class PassedCommandToken extends CommandToken implements Tokenizable {

	public PassedCommandToken(String newInput) {
		super(newInput);
	}

	void takeTokenAction(TalkingScene scene) {
		scene.KnightCrossBridge();		
	}

}
