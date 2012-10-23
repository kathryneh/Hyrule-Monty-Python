package scanner;

import tokens.AnimateCommandToken;
import tokens.FailedCommandToken;
import tokens.NumberToken;
import tokens.PassedCommandToken;
import tokens.RedoCommandToken;
import tokens.StringToken;
import tokens.UndoCommandToken;
import composition.TalkingScene;

public class IteratedTokenDefiner {
	IteratedScanner scanner;
	String string;
	TalkingScene scene;
	StringBuilder sb;
	MoveCommandUndoer undoer;
	private int moveValue = 0;
	private String commandType;
	
	public IteratedTokenDefiner(String args, TalkingScene s, MoveCommandUndoer undoer){
		string = args;
		scene = s;
		scanner = new IteratedScanner(args);
		sb = new StringBuilder();
		this.undoer = undoer;
	}
	
	public void setInput(String newInput){
		String localInputString = newInput+" ";
		scanner.setInput(localInputString);
		classifyTokens();
	}
	public void executeMoveCommand(int move){
		scene.moveKnightAvatarCollectionX(move);
	}
	public String parserReturnType(){
		return commandType;
	}
	
	public void classifyTokens(){
		while (scanner.hasNext()){
			String token = scanner.next();
			if (token.equals("move")){
				createMoveToken();
				commandType = "move";
			}
			else if (token.equals("say")){
				createSayToken();
				commandType = "null";
			}
			else if (token.equals("pass")){
				createPassToken();
				commandType = "null";
			}
			else if (token.equals("fail")){
				createFailToken();
				commandType = "null";
			}
			else if (token.equals("animate")){
				createAnimateToken();
				commandType = "null";
			}
			else if (token.equals("undo")){
				createUndoToken();
				commandType = "undo";
			}
			else if (token.equals("redo")){
				createRedoToken();
				commandType = "redo";
			}
			else {
				sb.append("Invalid input cannot be parsed. Please check input and try again.'\n'");
			}
		}
	}
	void createPassToken(){
		new PassedCommandToken(scene);
	}
	void createFailToken(){
		new FailedCommandToken(scene);
	}
	void createAnimateToken(){
		scanner.next();
		new AnimateCommandToken(scene);
	}
	void createUndoToken(){
		scanner.next();
		new UndoCommandToken(scene, undoer);
	}
	void createRedoToken(){
		scanner.next();
		new RedoCommandToken(scene, undoer);
	}
	void createSayToken(){
		String nextToken = scanner.next();
		new StringToken(nextToken, scene);
	}
	
	void createMoveToken(){
		String nextToken = scanner.next();
		if (nextToken.equals("+")){
			String nextToken1 = scanner.next();
			createNumberToken(nextToken1);
		}
		else if (nextToken.equals("-")){
			String nextToken1 = scanner.next();
			createNumberToken(nextToken1);
		}
		else{
			createNumberToken(nextToken);
		}
	}

	void createNumberToken(String nextToken){
		NumberToken numToken = new NumberToken(nextToken, scene, undoer);
		setMoveValue(numToken.getIntValue());
	}
	String getErrorLog(){
		return sb.toString();
	}
	public void setMoveValue(int move){
		moveValue = move;
	}
	public int getMoveValue(){
		return moveValue;
	}

	public String getInput() {
		return string;
	}
}