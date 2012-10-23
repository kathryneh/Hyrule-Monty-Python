package scanner;

import composition.TalkingScene;

public class Parser {//extends InheritedTokenScannerHistory implements Parsable {
	//String input;
	//private String returnedString;
	//private TokenScanner ts;
	private TalkingScene scene;
	InheritedTokenScannerHistory history;
	
	public Parser(String arg, TalkingScene newScene) {
		history = new InheritedTokenScannerHistory(arg);
		scene = newScene;
		
		//setInput(arg);
	}
	public String getInput() {
		return history.inputString;
	}
	
/*	
	public void setReturnedString(String tokenString) {
		// returnedString = returnedString + tokenString;
		//TokenScanner ts = new scanner.InheritedTokenScanner(input);
		returnedString = ts.toString();
	}
*/
	public void takeUserInput(String arg){
		setInput(arg);
	} 
	public void setInput(String newInput) {
		System.out.println("input entered: " + newInput);
		//if (input!= null){
		//input = input + newInput;
		//}
		//else{
		String localInputString = newInput+" ";
		history.setInput(localInputString);
		//}
		history.findTokens();
		//buildTokenList();
		TokenHistory tokenArray = getTokenList();
		tokenParser(tokenArray);
	}
	
	public TokenHistory getTokenList(){
		return history.tokenList;
	}
	
//	public String getReturnedString() {
//		return returnedString;
//	}
	public void tokenParser(TokenHistory listable){
		System.out.println("parseToken method begun");
		TokenHistory t = (TokenHistory) listable;
		java.lang.Object[] tokens = t.getObjectArray(); 
		System.out.println(t.size());
		for (int i = TokenNumber.getTokenNumber(); i<t.size(); i++){
			//System.out.println(t.size());
			System.out.println(tokens[i]);
			System.out.println(tokens[i+1]);
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
					TokenNumber.accessToken();

				}
				else if (tokens[i] instanceof PassedCommandToken){
					scene.KnightCrossBridge();
					TokenNumber.accessToken();
				}
				else if (tokens[i] instanceof FailedCommandToken){
					scene.KnightFallOffCliff();
					TokenNumber.accessToken();
				}
				else if (tokens[i] instanceof RedoCommandToken){
					tokens[i] = null;
					TokenNumber.tokenNumber -=2;
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
	public int parseMoveToken(java.lang.Object[] tokens, int i){
		System.out.println("Command to move"); 
		if (((Token)tokens[i+1]) instanceof NumberToken){
			scene.moveKnightAvatarCollectionX((((NumberToken) tokens[i+1]).getIntValue()));
			System.out.println("Command to Move to Number");
			TokenNumber.accessToken();
			return 1;
		}
		else if (((Token)tokens[i+1]) instanceof PlusToken){
			if (((Token)tokens[i+2]) instanceof NumberToken && tokens[i+2] != null){
				scene.moveKnightAvatarCollectionX((((PlusToken) tokens[i+1]).getCharValue()));
				TokenNumber.accessToken();
				TokenNumber.accessToken();
				return 2;
			}
		}
		else if (((Token)tokens[i+1]) instanceof MinusToken){
			if (((Token)tokens[i+2]) instanceof NumberToken && tokens[i+2] != null){
				scene.moveKnightAvatarCollectionX(-(((MinusToken) tokens[i+1]).getCharValue()));
				TokenNumber.accessToken();
				TokenNumber.accessToken();
				return 2;
			}
		}
		return 0;
	}
	public int parseSayToken(java.lang.Object[] tokens, int i){
		if (((Token)tokens[i+1]) instanceof StringToken){
			scene.speakAvatars(((Token)tokens[i+1]).getStringValue());
			TokenNumber.accessToken();
			return 1;
		}
		else return 0;
	}
}
