package scanner;

class TokenScanner implements Scanner {
	String inputString;
	int stringIndex;
	char curChar;
	String[] finalArray;
	int arrayIndex;

	public TokenScanner(String arg) {
		inputString = arg;
		finalArray = new String[inputString.length() / 2];
		arrayIndex = 0;
		findTokens();
		toString();
	}

	@Override
	public void findTokens() {
		curChar = inputString.charAt(stringIndex);
		for (stringIndex = 0; stringIndex < inputString.length(); stringIndex++) {
			curChar = inputString.charAt(stringIndex);
			if (curChar == '+') {
				findPlus();
			} else if (curChar == '-') {
				findMinus();
			} else if (curChar == ' ') {
			} else if (Character.isLetter(curChar)) {
				findCommand();
			} else if (Character.isDigit(curChar)) {
				findNumber();
			} else if (curChar == '"') {
				findQuotedString();
			} else if (curChar == '/') {
			}
		}
	}

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

	@Override
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
		scanner.NumberToken n1 = new scanner.NumberToken();
		n1.setStringValue(numberString);
		n1.setDescription();
		finalArray[arrayIndex] = n1.returnToken();
		arrayIndex++;
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
		scanner.CommandToken c1 = new scanner.CommandToken();
		c1.setStringValue(commandString);
		c1.setDescription();
		finalArray[arrayIndex] = c1.returnToken();
		arrayIndex++;

	}

	@Override
	public void findQuotedString() {
		stringIndex++;
		int startIndex = this.stringIndex;
		int endIndex = 0;

		for (int stringIndex = this.stringIndex; stringIndex < inputString
				.length(); this.stringIndex++) {
			if (inputString.charAt(stringIndex) != '"') {

			} else if (inputString.charAt(this.stringIndex) == '"') {
				endIndex = this.stringIndex;
				break;
			}
		}
		String quotedString = inputString.substring(startIndex, endIndex);
		scanner.QuotedStringToken qs1 = new scanner.QuotedStringToken();
		qs1.setStringValue(quotedString);
		qs1.setDescription();
		finalArray[arrayIndex] = qs1.returnToken();
		arrayIndex++;

	}


	@Override
	public String toString() {
		StringBuilder finalInputString = new StringBuilder();
		// builds a string from the array so it doesn't just return to me the
		// memory location of finalArray
		for (int i = 0; i < arrayIndex; i++) {
			finalInputString.append(finalArray[i] + " ; ");
		}
		return finalInputString.toString();
	}

}
