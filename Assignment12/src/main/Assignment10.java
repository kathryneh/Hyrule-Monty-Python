package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment10 {
	public static void main(String[] args){
		composition.TalkingScene t = new composition.TalkingScene();
		scanner.Parser p = new scanner.Parser(" ", t);
		OEFrame frame = ObjectEditor.edit(t);
		ObjectEditor.edit(p);
		frame.hideMainPanel();
		frame.setSize(1021, 651);
		
	}
}