package tokens;

interface Tokenizable {
	public String getStringValue();

	public String getDescription();

	public void setStringValue(String input);

	public void setDescription(String newDescription);

	public String getToken();
	
	public String toString();
	
}
