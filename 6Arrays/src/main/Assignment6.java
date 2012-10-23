package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment6 {
	public static void main(String[] args) {
		
		chat.TextLabel tl = new chat.TextLabel(0 , 0 , 200 , 20 ,
		"Hello world!"); 
		ObjectEditor.edit(tl); 
		 
		chat.chatHistory ch = new chat.chatHistory(0, 200,"If at first you don't succeed, call it v1.0");
		ch.push("A man said to the universe:"); 
		ch.push("'Sir I exist!'");
		ch.push("'However,' replied the universe, ");
		ch.push("'The fact has not created in me ");
		ch.push("A sense of obligation.'");
		ObjectEditor.edit(ch);
		
		avatars.TalkingGuardAvatar tga = new avatars.TalkingGuardAvatar(20, 90,"Microsoft:");
		tga.push("You've got questions");
		tga.push("We've got dancing paperclips");
		avatars.TalkingKnightAvatar tka = new avatars.TalkingKnightAvatar(40,
		90, "I would love to change the world");
		tka.push("but they won't give me the source code");
		ObjectEditor.edit(tga);
		ObjectEditor.edit(tka);
		
		avatars.KnightAvatarCollection kac = new avatars.KnightAvatarCollection(250, 0);
		kac.push("This is the song that never ends");
		kac.push("it goes on and on my friends");
		kac.push("So if you're tired of hearing it");
		kac.push("and knowing what it does");
		OEFrame frame2 = ObjectEditor.edit(kac);
		frame2.setSize(600, 600);
		
		composition.TalkingKnightComposition TKC = new composition.TalkingKnightComposition();
		OEFrame TKCframe = ObjectEditor.edit(TKC);
		TKCframe.setSize(1021, 651);
		
	}
}

// A man said to the universe:
// "Sir I exist!"
// "However," replied the universe,
// "The fact has not created in me
// A sense of obligation." 