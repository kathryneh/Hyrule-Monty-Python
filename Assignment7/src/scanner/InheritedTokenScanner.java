package scanner;

public class InheritedTokenScanner extends TokenScanner implements Scanner {

	
	public InheritedTokenScanner(String arg) {
		super(arg);
	}
	@Override
	public void findCommand() {
		int i = this.stringIndex;
		int startIndex = this.stringIndex;
		int endIndex = 0;
		for (i = this.stringIndex; i < inputString.length(); this.stringIndex++) {
			if (Character.isLetter(inputString.charAt(this.stringIndex))) {

			} else if (inputString.charAt(this.stringIndex) == ' ') {
				endIndex = this.stringIndex;
				break;
			}
		}
		String commandString = inputString.substring(startIndex, endIndex);
		characterizeCommand(commandString);
		//scanner.CommandToken c1 = new scanner.CommandToken();
		//c1.setStringValue(commandString);
		//c1.setDescription();
		//finalArray[arrayIndex] = c1.returnToken();
		//arrayIndex++;

	}
	public void characterizeCommand(String commandString){
		if (  (commandString.toLowerCase().equals("move")) 
			||(commandString.toLowerCase().equals("mv"))) {
			scanner.MoveCommandToken c1 = new scanner.MoveCommandToken();
			c1.setStringValue(commandString);
			c1.setDescription();
			finalArray[arrayIndex] = c1.returnToken();
			arrayIndex++;
			//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("say")) 
				||(commandString.toLowerCase().equals("sy"))) {
				scanner.SayCommandToken c1 = new scanner.SayCommandToken();
				c1.setStringValue(commandString);
				c1.setDescription();
				finalArray[arrayIndex] = c1.returnToken();
				arrayIndex++;
				//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("passed")) 
				||(commandString.toLowerCase().equals("pass"))) {
				scanner.PassedCommandToken c1 = new scanner.PassedCommandToken();
				c1.setStringValue(commandString);
				c1.setDescription();
				finalArray[arrayIndex] = c1.returnToken();
				arrayIndex++;
				//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("failed")) 
				||(commandString.toLowerCase().equals("fail"))) {
				scanner.FailedCommandToken c1 = new scanner.FailedCommandToken();
				c1.setStringValue(commandString);
				c1.setDescription();
				finalArray[arrayIndex] = c1.returnToken();
				arrayIndex++;
				//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("undo")) 
				||(commandString.toLowerCase().equals("cancel"))) {
				scanner.UndoCommandToken c1 = new scanner.UndoCommandToken();
				c1.setStringValue(commandString);
				c1.setDescription();
				finalArray[arrayIndex] = c1.returnToken();
				arrayIndex++;
				//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("redo")) 
				||(commandString.toLowerCase().equals("repeat"))) {
				scanner.RedoCommandToken c1 = new scanner.RedoCommandToken();
				c1.setStringValue(commandString);
				c1.setDescription();
				finalArray[arrayIndex] = c1.returnToken();
				arrayIndex++;
				//System.out.println("found token");
		}
		else{
			System.out.println("Unknown command" + " " + commandString);
		}
	}
}
