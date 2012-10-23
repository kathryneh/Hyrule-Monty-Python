package main;

import scanner.MoveCommandUndoer;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment13 {
	public static void main(String[] args){
		MoveCommandUndoer undoer = new MoveCommandUndoer();
		composition.TalkingScene t = new composition.TalkingScene();
		scanner.UndoableIteratedParser p = new scanner.UndoableIteratedParser(" ", t, undoer);
		OEFrame frame = ObjectEditor.edit(t);
		ObjectEditor.edit(p);
		frame.hideMainPanel();
		frame.setSize(1021, 651);
		composition.TalkingScene r = new composition.TalkingScene();
		scanner.UndoableParser q = new scanner.UndoableParser(" ", r);
		OEFrame frame2 = ObjectEditor.edit(r);
		ObjectEditor.edit(q);
		frame2.hideMainPanel();
		frame2.setSize(1021, 651);
	}
}
