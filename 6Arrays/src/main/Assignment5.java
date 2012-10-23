package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment5 {
	public static void main(String args[]) {
		// ObjectEditor.setDefaultAttribute(AttributeNames.COMPONENT_WIDTH,
		// 1442);
		// ObjectEditor.setDefaultAttribute(AttributeNames.COMPONENT_HEIGHT,
		// 818);
		// ObjectEditor.edit(new avatars.KnightAvatar(300, 285));
		// ObjectEditor.edit(new avatars.GuardAvatar(300, 285));
		// OEFrame frame = ObjectEditor.edit(new scenery.BridgeScenery(0,0));

		composition.CompleteComposition comp = new composition.CompleteComposition();
		OEFrame frame = ObjectEditor.edit(comp);
		frame.setSize(1021, 651);

		composition.NoKnightComposition comp1 = new composition.NoKnightComposition();
		OEFrame frame1 = ObjectEditor.edit(comp1);
		frame1.setSize(1021, 651);

		composition.ScrollableComposition comp2 = new composition.ScrollableComposition();
		OEFrame frame2 = ObjectEditor.edit(comp2);
		frame2.setSize(1021, 651);

		// ObjectEditor.edit(comp);
		// OEFrame frame = ObjectEditor.edit(new scenery.BridgeScenery());
		// frame.setSize(1021, 651);
	}

}
