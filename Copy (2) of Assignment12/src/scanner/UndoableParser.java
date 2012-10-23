package scanner;

import composition.TalkingScene;

public class UndoableParser implements Undoer {
	Parser parser;
	int oldMove;
	int newMove;
	MoveCommandUndoer undoer;
	
	public UndoableParser(String arg, TalkingScene newScene){
		parser = new Parser(arg, newScene);
	}

	@Override
	public void undo() {
		undoer.undo();
	}
	public int getMoveValue(){
		return parser.getMoveValue();
	}

	@Override
	public void redo() {
		undoer.redo();
	}
	public void setMoveValue(){
		undoer.execute(new MoveCommand(parser, newMove));
	}

}