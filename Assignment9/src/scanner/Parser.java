package scanner;

import util.annotations.Visible;
import composition.TalkingScene;

public class Parser extends InheritedTokenScannerHistory implements Parsable {
	//String input;
	private String returnedString;
	private TokenScanner ts;
	private TalkingScene scene;

	public Parser(String arg, TalkingScene newScene) {
		super(arg);
		scene = newScene;
		//setInput(arg);
	}
	public String getInput() {
		return inputString;
	}
	@Visible(false)
	public void setReturnedString(String tokenString) {
		// returnedString = returnedString + tokenString;
		//TokenScanner ts = new scanner.InheritedTokenScanner(input);
		returnedString = ts.toString();
	}
	public void takeUserInput(String arg){
		setInput(arg);
	}
	@Override 
	public void setInput(String newInput) {
		//if (input!= null){
		//input = input + newInput;
		//}
		//else{
		inputString = newInput;
		super.setInput(inputString);
		//}
		findTokens(inputString);
		buildTokenList();
		tokenParser(getTokenList());

	}
	@Visible(false)
	public String getReturnedString() {
		return returnedString;
	}
	public void tokenParser(TokenHistory listable){
		System.out.println("parseToken method begun");
		TokenHistory t = (TokenHistory) listable;
		Token[] tokens = t.tokenCollection; 
		for (int i = 0 ; i<t.size()-1 ; i++){
			//System.out.println(t.size());
			System.out.println(tokens[i]);
			//String tDesc=null;
			//if (tokens[i]!=null){
			//tDesc = tokens[i].getDescription(); 
			//}
			//String tDescNext = tokens[i+1].getDescription();
			//String tDescThird = tokens[i+2].getDescription();
			if(tokens[i] instanceof CommandToken){
				if (tokens[i] instanceof MoveCommandToken){
					i = i+ parseMoveToken(tokens, i);
					
				}
				else if (tokens[i] instanceof SayCommandToken){
					i = i + parseSayToken(tokens, i);
					System.out.println("Say command completed");

				}
				else if (tokens[i] instanceof PassedCommandToken){
					scene.KnightCrossBridge();
				}
				else if (tokens[i] instanceof FailedCommandToken){
					scene.KnightFallOffCliff();
				}
				else if (tokens[i] instanceof RedoCommandToken){
					tokens[i] = null;
					i--;
					i--;
				}
			}
			else if (tokens[i] == null){
			}
			else {
				System.out.println("Invalid token order");
				System.out.println("Error token" + tokens[i]);
			}
		}
	}
	public int parseMoveToken(Token[] tokens, int i){
		System.out.println("Command to move");
		if (tokens[i+1] instanceof NumberToken){
			scene.moveKnightAvatarCollectionX((((NumberToken) tokens[i+1]).getIntValue()));
			System.out.println("Command to Move to Number");
			return 1;
		}
		else if (tokens[i+1] instanceof PlusToken){
			if ((tokens[i+2] instanceof NumberToken && tokens[i+2] != null)){
				scene.moveKnightAvatarCollectionX((((PlusToken) tokens[i+1]).getCharValue()));
				return 2;
			}
		}
		else if (tokens[i+1] instanceof MinusToken){
			if ((tokens[i+2] instanceof NumberToken && tokens[i+2] != null)){
				scene.moveKnightAvatarCollectionX(-(((MinusToken) tokens[i+1]).getCharValue()));
				return 2;
			}
		}
		return 0;
	}
	public int parseSayToken(Token[] tokens, int i){
		if (tokens[i+1] instanceof StringToken){
			scene.speakAvatars(tokens[i+1].getStringValue());
			return 1;
		}
		else return 0;
	}
}
