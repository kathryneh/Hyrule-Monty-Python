package scanner;

public class InheritedTokenScannerHistory extends TokenScanner implements InheritedScannable {

	public InheritedTokenScannerHistory(String arg) {
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
			scanner.MoveCommandToken c1 = new scanner.MoveCommandToken(commandString);
			tokenList.push(c1);
			arrayIndex++;
			System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("say")) 
				||(commandString.toLowerCase().equals("sy"))) {
			scanner.SayCommandToken c1 = new scanner.SayCommandToken(commandString);
			tokenList.push(c1);
			arrayIndex++;
			//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("passed")) 
				||(commandString.toLowerCase().equals("pass"))) {
			scanner.PassedCommandToken c1 = new scanner.PassedCommandToken(commandString);
			tokenList.push(c1);
			arrayIndex++;
			//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("failed")) 
				||(commandString.toLowerCase().equals("fail"))) {
			scanner.FailedCommandToken c1 = new scanner.FailedCommandToken(commandString);
			tokenList.push(c1);
			arrayIndex++;
			//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("undo")) 
				||(commandString.toLowerCase().equals("cancel"))) {
			scanner.UndoCommandToken c1 = new scanner.UndoCommandToken(commandString);
			tokenList.push(c1);
			arrayIndex++;
			//System.out.println("found token");
		}
		else if (  (commandString.toLowerCase().equals("redo")) 
				||(commandString.toLowerCase().equals("repeat"))) {
			scanner.RedoCommandToken c1 = new scanner.RedoCommandToken(commandString);
			tokenList.push(c1);
			arrayIndex++;
			//System.out.println("found token");
		}
		else{
			System.out.println("Unknown command" + " " + commandString);
		}
	}
/*	public void buildTokenList(){
		//TokenList tokenList = new TokenList();
		for (int i = 0; i < arrayIndex+1; i++){
			tokenList.push(finalArray[i]);
			System.out.println("Final Array: "+ finalArray[i]);
			//TokenArrayIndex++;
			System.out.println("TokenList accessed");
			System.out.println("Token List: " + tokenList.elementAt(i));
		}
		//return tokenList;
	}
	*/

	

}
