package scanner;

interface Tokenizable {
	public String getStringValue();

	public String getDescription();

	public void setStringValue(String input);

	public void setDescription();

	public String returnToken();
	
	public String toString();
}
