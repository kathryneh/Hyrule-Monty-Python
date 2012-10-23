package input;

import token.ErroneousQuote;
import token.Tokens;
import util.annotations.ComponentWidth;

public class Stateful implements Statefuls{
	String string,error,scanned="";
	public Stateful(String string){
		setString(string);
	}
	@Override
	@ComponentWidth (225)
	public String getString(){
		return string;
	}
	protected Tokens[] method(String string){
		 return Transpose.transpose(string,new Tokens[0],false);
	}
	//Converts the transposed array of Tokens to a String and sets this as the instance variable.
	@Override
	public void setString(String string){
		this.string=string;
		error="";
		scanned="";
		Tokens[] a=method(string);
		String foo="";
		for(Tokens b: a){
			if(b instanceof ErroneousQuote){
				error+="Error: Quoted String not Closed; ";
				break;
			}
			else if(b instanceof Error){
				error+="Illegal Character \""+b.toString()+"\" Entered; ";
				continue;
			}
			foo+=(b.getClass()+"").substring(12)+": "+b.toString()+"; ";
		}
		this.scanned=foo;
	}
	
	//converts a Token to a String output
	@Override
	public String getScanned(){
		return scanned;
	}
	@Override
	@ComponentWidth (225)
	public String getError(){
		return error;
	}
}
