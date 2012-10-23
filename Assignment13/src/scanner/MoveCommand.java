package scanner;

public class MoveCommand implements Command {
	Parser parser;
	int newMove;
	int undoMove;
	IteratedTokenDefiner itd;
	
	public MoveCommand (Parser parser, int newMove){
		this.parser = parser;
		undoMove = (-newMove);
		this.newMove = newMove;
	}
	public MoveCommand(IteratedTokenDefiner iteratedTokenDef, int moveValue) {
		itd = iteratedTokenDef;
		undoMove = (-moveValue);
		newMove = moveValue;
	}
	@Override
	public void execute() {
		parser.executeMoveCommand(newMove);
		parser.setMoveValue(newMove);
	}
	public void executeIterated(){
		itd.executeMoveCommand(newMove);
		itd.setMoveValue(newMove);
	}
	
	public void undoIterated(){
		itd.executeMoveCommand(undoMove);
	}
	
	@Override
	public void undo() {
		parser.executeMoveCommand(undoMove);
		
	}


}
