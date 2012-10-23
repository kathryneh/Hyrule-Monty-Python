package scanner;

import java.util.ArrayList;
import java.util.List;

public class MoveCommandUndoer implements Undoer {
	List<Command> historyList = new ArrayList<Command>();
	int nextCommandIndex = 0;
	
	public void execute (Command c) {
		  while(nextCommandIndex < historyList.size()) {
		    historyList.remove(nextCommandIndex); // clear redo chain
		  }
		  c.execute();
		  historyList.add(c);
		  nextCommandIndex++;
		  System.out.println("Move command executed");
		}
	
	public void executeIterated(Command c) {
		System.out.println("executeIterated run");
		  while(nextCommandIndex < historyList.size()) {
		    historyList.remove(nextCommandIndex); // clear redo chain
		  }
		  c.executeIterated();
		  historyList.add(c);
		  nextCommandIndex++;
		  System.out.println("Iterated move command executed");
		  System.out.println(this);
		  System.out.println("Next Command Index" + nextCommandIndex);
		}
	
	public void undo() {
		  assert preUndo();
		  nextCommandIndex--;
		  Command c = historyList.get(nextCommandIndex);
		  c.undo();    
		}
	public void undoIterated() {
		 System.out.println(this);
		  assert preUndo();
		  nextCommandIndex--;
		  System.out.println("Next Command Index" + nextCommandIndex);
		  Command c = historyList.get(nextCommandIndex);
		  c.undoIterated();    
		}
	
	public boolean preUndo(){
		return (nextCommandIndex !=0);
	}
	public void redo() {
		   assert preRedo();
		   Command c = historyList.get(nextCommandIndex);
		   c.execute();
		   nextCommandIndex++;
		}
	public void redoIterated() {
		   assert preRedo();
		   Command c = historyList.get(nextCommandIndex);
		   c.executeIterated();
		   nextCommandIndex++;
		}
	
	public boolean preRedo(){
		return (nextCommandIndex!= historyList.size());
	}

}

