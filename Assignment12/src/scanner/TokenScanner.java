package scanner;

public abstract class TokenScanner implements Scannable{
	protected String inputString;
	protected int stringIndex;
	protected char curChar;
	//protected Token[] finalArray = new Token[50];
	protected int arrayIndex = 0;
	protected String arg;
	protected TokenHistory tokenList = new TokenHistory();
	protected int TokenArrayIndex = 0;

	public TokenScanner(String arg) {
		setInput(arg);
		//finalArray = new Token[50];
		//findTokens(arg);
	}
	public void setInput(String arg){
		inputString=arg;
		//System.out.println("Input String = " + inputString);
		//findTokens(arg);
	}

	public void findTokens() {
		System.out.println("Find Tokens with input: " + inputString);
		stringIndex = 0;
		if (arrayIndex != 0){
			arrayIndex --;
		}
		if ((inputString!=null) && stringIndex<inputString.length()){
			curChar = inputString.charAt(stringIndex);
		//	System.out.println(stringIndex + inputString.length());
			for (stringIndex = 0; stringIndex < inputString.length(); stringIndex++) {
				curChar = inputString.charAt(stringIndex);
			//	System.out.print(curChar);
				if (curChar == '+') {
					findPlus();
				}else if (curChar == '-') {
					findMinus();
				}
				else if (curChar == ' ') {
				}else if (curChar == '"') {
					findQuotedString();
				}else if (curChar == '/') {
				}else if (Character.isLetter(curChar)) {
					findCommand();
				} else if (Character.isDigit(curChar)) {
					findNumber();
				}
			}
		}
	}
	
public void findPlus() {
	scanner.PlusToken p1 = new scanner.PlusToken(curChar);
	//finalArray[arrayIndex] = p1;
	tokenList.push(p1);
	arrayIndex++;
}


public void findMinus() {
	scanner.MinusToken m1 = new scanner.MinusToken(curChar);
	//finalArray[arrayIndex] = m1;
	tokenList.push(m1);
	arrayIndex++;
}

public void findNumber() {
	int i = stringIndex;
	int startIndex = i;
	int endIndex = 0;

	for (i = stringIndex; stringIndex < inputString.length(); stringIndex++) {
		if (Character.isDigit(inputString.charAt(stringIndex))) {

		} else if (inputString.charAt(this.stringIndex) == ' ') {
			endIndex = this.stringIndex;
			break;
		}
	}

	String numberString = inputString.substring(startIndex, endIndex);
	scanner.NumberToken n1 = new scanner.NumberToken(numberString);
	//n1.setStringValue(numberString);
	//n1.setDescription();
	//finalArray[arrayIndex] = n1;
	tokenList.push(n1);
	arrayIndex++;
	System.out.println("Found number token");
}

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
	scanner.CommandToken c1 = new scanner.CommandToken(commandString);
	//c1.setStringValue(commandString);
	//c1.setDescription();
	//finalArray[arrayIndex] = c1;
	tokenList.push(c1);
	arrayIndex++;

}

public void findQuotedString() {
	stringIndex++;
	int startIndex = this.stringIndex;
	int endIndex = 0;

	for (int stringIndex = this.stringIndex; stringIndex < inputString
			.length(); this.stringIndex++) {
		curChar = inputString.charAt(this.stringIndex);
		//	System.out.println(curChar);
		if (curChar != '"') {

		} else if (inputString.charAt(this.stringIndex) == '"') {
			endIndex = this.stringIndex;
			break;
		} 
	}
	String quotedString = inputString.substring(startIndex, endIndex);
	scanner.StringToken qs1 = new scanner.StringToken(quotedString);
	//qs1.setStringValue(quotedString);
	//qs1.setDescription();
	tokenList.push(qs1); 
	arrayIndex++;

}

/*public String toString() {
	StringBuilder finalInputString = new StringBuilder();
	// builds a string from the array so it doesn't just return to me the
	// memory location of finalArray
	for (int i = 0; i < arrayIndex; i++) {
		finalInputString.append(finalArray[i] + " ; ");
	}
	return finalInputString.toString();
}
*/
/*@Visible(false)
public void buildTokenList(){
	for (int i = 0; i < arrayIndex; i++){
		tokenList.addToken(finalArray[i]);
	}
}	public TokenList getTokenList(){
	return tokenList;
}

public void buildTokenList(){
	//TokenList tokenList = new TokenList();
	for (int i = TokenArrayIndex; i < arrayIndex+1; i++){
		tokenList.addToken(finalArray[i]);
		System.out.println("Final Array"+ finalArray[i]);
		TokenArrayIndex++;
		System.out.println("TokenList accessed");
		System.out.println("Token List" + tokenList.tokenAt(i));
	}
	//return tokenList;
}
public TokenList getTokenList(){
	return tokenList;
}
*/
}
