package input;

public class BooleanString implements BooleanStrings{
	String s;
	boolean ß;
	public BooleanString(String s,boolean ß){
		this.s=s;
		this.ß=ß;
	}
	@Override
	public String getString() {
		return s;
	}
	@Override
	public boolean getBoole() {
		return ß;
	}

}
