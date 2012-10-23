package input;

import token.Tokens;

public class NStateful extends Stateful implements Statefuls{
	public NStateful(String string) {
		super(string);
	}
	@Override
	protected Tokens[] method(String string){
		 return Transpose.transpose(string,new Tokens[0],true);
	}

}
