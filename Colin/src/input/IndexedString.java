package input;

public class IndexedString implements IndexedStrings{
	String s;
	int i;
	public IndexedString(String s,int i){
		this.s=s;
		this.i=i;
	}
	@Override
	public String getString(){
		return s;
	}
	@Override
	public int getIndex(){
		return i;
	}
}
