package scanner;

public interface Undoer {   
    public void undo();
    public void redo();
    public boolean preRedo();
    public boolean preUndo();
	public void undoIterated();
}
