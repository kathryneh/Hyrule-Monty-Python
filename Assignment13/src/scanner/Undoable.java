package scanner;

public interface Undoable {
	public void undo();
    public void redo();
    public void setInput(String input);
    public String getInput();
    public int getMoveValue();
    public void setMoveValue();
}
