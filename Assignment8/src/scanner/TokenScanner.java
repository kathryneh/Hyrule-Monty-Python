package scanner;

class TokenScanner implements Scannable {
	String inputString;
	int stringIndex;
	char curChar;
	Token[] finalArray;
	int arrayIndex;

	public TokenScanner(String arg) {
		setTokenString(arg);
		finalArray = new Token[inputString.length() / 2];
		arrayIndex = 0;
		findTokens();
		toString();
	}
	public void setTokenString(String arg){
		inputString = arg;
	}

	public void findTokens() {
		curChar = inputString.charAt(stringIndex);
		for (stringIndex = 0; stringIndex < inputString.length(); stringIndex++) {
			curChar = inputString.charAt(stringIndex);
			//System.out.print(curChar);
			//if (curChar == '+') {
			//	findPlus();
			//} else if (curChar == '-') {
			//	findMinus();
			  if (curChar == ' ') {
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
	//}
	/*
	@Override
	public void findPlus() {
		scanner.PlusToken p1 = new scanner.PlusToken();
		p1.setStringValue(Character.toString(curChar));
		p1.setDescription();
		finalArray[arrayIndex] = p1.returnToken();
		arrayIndex++;
	}

	@Override
	public void findMinus() {
		scanner.MinusToken m1 = new scanner.MinusToken();
		m1.setStringValue(Character.toString(curChar));
		m1.setDescription();
		finalArray[arrayIndex] = m1.returnToken();
		arrayIndex++;
	}
	*/

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
		finalArray[arrayIndex] = n1;
		arrayIndex++;
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
		finalArray[arrayIndex] = c1;
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
		finalArray[arrayIndex] = qs1;
		arrayIndex++;

	}


	public String toString() {
		StringBuilder finalInputString = new StringBuilder();
		// builds a string from the array so it doesn't just return to me the
		// memory location of finalArray
		for (int i = 0; i < arrayIndex; i++) {
			finalInputString.append(finalArray[i] + " ; ");
		}
		return finalInputString.toString();
	}
	public Listable getTokenList(){
		TokenList tokenList = new TokenList();
		for (int i = 0; i < arrayIndex; i++){
			tokenList.addToken(finalArray[i]);
		}
		return tokenList;
	}
}
