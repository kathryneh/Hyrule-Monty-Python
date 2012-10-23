package token;

public abstract class Token implements Tokens{
	String data;
	public Token(String data){
		this.data=data;
	}
	@Override
	public String toString(){
		return data;
	}
}
