package scanner;

public class MoveCommand implements Command {
	Parser parser;
	int newMove;
	int undoMove;
	
	public MoveCommand (Parser parser, int newMove){
		this.parser = parser;
		undoMove = (-newMove);
		this.newMove = newMove;
	}
	@Override
	public void execute() {
		parser.executeMoveCommand(newMove);
		parser.setMoveValue(newMove);
	}

	@Override
	public void undo() {
		parser.executeMoveCommand(undoMove);
		
	}


}
