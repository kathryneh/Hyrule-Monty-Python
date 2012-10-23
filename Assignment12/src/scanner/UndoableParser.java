package scanner;

import composition.TalkingScene;

public class UndoableParser implements Undoer {
	Parser parser;
	int oldMove;
	int newMove;
	MoveCommandUndoer undoer;

	public UndoableParser(String arg, TalkingScene newScene){
		undoer = new MoveCommandUndoer();
		parser = new Parser (arg, newScene);
	}

	public void setInput(String newInput){
		parser.setInput(newInput);
		if (parser.parserReturnType()!= null){
			if (parser.parserReturnType().equals("redo")){
				undoer.redo();
			}
			else if (parser.parserReturnType().equals("undo")){
				undoer.undo();
			}
			else if (parser.parserReturnType().equals("move")){
				System.out.println("Parser return type" + parser.parserReturnType());
				System.out.println("Parser" + parser);
				System.out.println("Undoer" + undoer);
				undoer.execute(new MoveCommand(parser, parser.getMoveValue()));
				//undoer.execute(new MoveCommand(parser, 10 ));
			}
		}
	}
	public String getInput(){
		return parser.getInput();
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
		undoer.execute(new MoveCommand(parser, getMoveValue()));
	}

}