package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment8 {
	public static void main(String[] args){
		composition.TalkingScene t = new composition.TalkingScene();
		OEFrame frame = ObjectEditor.edit(t);
		frame.hideMainPanel();
		frame.setSize(1021, 651);
		
	}
}

