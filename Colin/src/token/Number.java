package token;

public class Number extends Token implements NumberTokens{
	public Number(String data){
		super(data);
	}
	public int getData(){
		return Integer.parseInt(super.data);
	}
}
