package main;

import bus.uigen.ObjectEditor;

public class Assignment7 {

	public static void main(String[] args) {
		if (args.length != 1){
			System.out.println("No valid argument passed");
		}
		else{
			/*scanner.StatefulObject so = new scanner.StatefulObject(args[0]);
			so.setInput(args[0]);
			System.out.println(so.getReturnedString());
			
			avatars.TalkingKnightAvatar l = new avatars.TalkingKnightAvatar(150, 150, "hello");
			ObjectEditor.edit(l);
			avatars.TalkingGuardAvatar g = new avatars.TalkingGuardAvatar(150, 150, "hello");
			ObjectEditor.edit(g);
			avatars.AlignedTalkingKnight k = new avatars.AlignedTalkingKnight(150, 150, "Hello");
			k.push(0, 75, "I love you");
			k.push(0, 50, "Won't you tell me your name?");
			ObjectEditor.edit(k);
			avatars.AlignedTalkingGuard g = new avatars.AlignedTalkingGuard(150, 150, "The cake is not a lie.");
			g.push(0, 75, "I don't hate you.");
			g.push(0, 50, "If you're good, you'll get cake.");
			ObjectEditor.edit(g);
			avatars.FallenCollection f = new avatars.FallenCollection(300, 100);
			f.push(0,0, "I'm a mac!", "guard");
			f.push(0,0,"I'm a PC", "knight");
			f.push(0, 0, "I'm a penguin!", "knight");
			ObjectEditor.edit(f);
			
			avatars.AlignedSpacedCollection a = new avatars.AlignedSpacedCollection(200, 100);
			a.push(0,0, "If a man speaks", "guard");
			a.push(0,0,"and no woman hears him", "knight");//type here doesn't matter; they are all knights
			a.push(0,0, "is he still wrong?", null);
			ObjectEditor.edit(a);
			*/
			avatars.KnightCollection h = new avatars.KnightCollection(200, 100);
			h.push(0,0, "This joke could not be found.",null);
			h.push(0,0, "Error 404", null);
			ObjectEditor.edit(h);
			//chat.AlignedChatHistory c = new chat.AlignedChatHistory(100, 200, "Trick or treat!");
			//c.push(100, 100, "Give me something good to eat!");
			//c.push(0, 75, "Give me candy or give me death!");
			//ObjectEditor.edit(c);
			
		}
	}
}
