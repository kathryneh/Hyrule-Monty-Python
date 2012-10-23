package scanner;

public interface Command {
    public  void execute();
    public  void  undo();
	public void executeIterated();
	public void undoIterated();
}

