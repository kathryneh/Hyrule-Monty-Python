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
		}

	public void undo() {
		  if (nextCommandIndex != 0){
		  nextCommandIndex--;
		  Command c = historyList.get(nextCommandIndex);
		  c.undo();    
		  }
		}
	
	public void redo() {
		   if (nextCommandIndex != historyList.size()){
		   Command c = historyList.get(nextCommandIndex);
		   c.execute();
		   nextCommandIndex++;
		   }
		}

}

