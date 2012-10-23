package scanner;

import composition.TalkingScene;

public class NumberToken extends Token implements Tokenizable {
	public NumberToken(String input) {
		super(input);
		setDescription("Number");
	}
	int stringValue;
	@Override
	//this overriden method changes the string input value to an integer
	public void setStringValue(String input){
		stringValue = Integer.parseInt(input);
	}

	public int getIntValue(){
		return stringValue;
	}

	void takeTokenAction(TalkingScene scene, int x) {
		scene.moveKnightAvatarCollectionX(x);		
	}
}
