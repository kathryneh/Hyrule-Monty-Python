package main;

import token.Number;
import parts.ChatKnightParts;
import parts.ChatKnights;
import parts.FallenMovableParts;
import parts.FallenMovables;
import input.BooleanString;
import input.IndexedString;
import input.NStateful;
import input.Stateful;
import equipment.AlignedChatHistory;
import equipment.LabelCollections;
import token.Move;
import graphics.Point;
import bus.uigen.ObjectEditor;

public class Assignment7 {
	public static void main(String[] args) {
		System.out.println("input value: 10\nread value: "+(new Number("10")).getData());
		System.out.println("\ninput type: Move\ntest type: Move\ninstanceof comparison: "+((new Move("mv"))instanceof Move));
		System.out.println("\ninput type: Move\ninput value: mv\noutput value: "+new Move("mv"));
		System.out.println(new Stateful("test failed fl").getScanned());
		System.out.println(new NStateful("test failed fl").getScanned()+"\n");
		FallenMovableParts a=new FallenMovables(new Point(10,10),new BooleanString[]{new BooleanString("Eddard",false),new BooleanString("Jon",true),new BooleanString("Tyrion",true)});
		LabelCollections b=new AlignedChatHistory(new Point(10,70), new String[]{"Eddard","Jon","Tyrion","Jamie"});
		ChatKnightParts c=new ChatKnights(new Point(10,100),new String[]{"Eddard","Jon","Tyrion","Jamie","Theon"}, new IndexedString[]{new IndexedString("Hi",0),new IndexedString("We are from Westeros",1),new IndexedString("Frak, off you all.",2),new IndexedString("Are you Daleks?",4),new IndexedString("No, they are Cylons!",3)});
		((AlignedChatHistory)b).add("test",new Point(20,20));
		ObjectEditor.edit(a);
		ObjectEditor.edit(b);
		ObjectEditor.edit(c);
	}
}
