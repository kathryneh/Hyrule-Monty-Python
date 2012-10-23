package tokens;

import scanner.Undoer;
import composition.TalkingScene;

public class RedoCommandToken extends CommandToken implements Tokenizable {
	TalkingScene s;
	Undoer undoer;
		public RedoCommandToken(String newInput) {
			super(newInput);
		}

		public RedoCommandToken(TalkingScene scene, Undoer undoer) {
			super("redo");
			s = scene;
			this.undoer = undoer;
			takeTokenAction();
		}
		void takeTokenAction(){
			undoer.redo();
		}

	}