package input;

import token.Command;
import token.ErroneousQuote;
import token.Error;
import token.Failed;
import token.Move;
import token.Number;
import token.Passed;
import token.Plus;
import token.Quote;
import token.Minus;
import token.Redo;
import token.Say;
import token.Scroll;
import token.Tokens;
import token.Undo;

public class StaticDynamicArray {
	//add one element to an array at the position beneath the last
	//for Token array
	public static Tokens[] add(Tokens[] a,String b,String c){
		Tokens d=null;
		if(b.charAt(0)=='C'){
			if(b.charAt(1)=='o')d=new Command(c);
			if(b.charAt(1)=='F')d=new Failed(c);
			else if(b.charAt(1)=='M')d=new Move(c);
			else if(b.charAt(1)=='P')d=new Passed(c);
			else if(b.charAt(1)=='R')d=new Redo(c);
			else if(b.charAt(1)=='S')
				if(b.charAt(2)=='a')d=new Say(c);
				if(b.charAt(2)=='c')d=new Scroll(c);
			else if(b.charAt(1)=='U')d=new Undo(c);
		}
		else if(b.charAt(0)=='Q')d=new Quote(c);
		else if(b.charAt(0)=='0')d=new ErroneousQuote();
		else if(b.charAt(0)=='E')d=new Error(c);
		else if(b.charAt(0)=='N')d=new Number(c);
		else if(b.charAt(0)=='P')d=new Plus();
		else if(b.charAt(0)=='M')d=new Minus();
		Tokens tmp[]=new Tokens[a.length+1];
		for(int i=0;i<a.length;i++)
			tmp[i]=a[i];
		tmp[a.length]=d;
		return tmp;
	}
	public static Object[] add(Object[] a,Object b){
		Object tmp[]=new Object[a.length+1];
		for(int i=0;i<a.length;i++)
			tmp[i]=a[i];
		tmp[a.length]=b;
		return tmp;
	}
	//for String array
	public static String[] add(String[] a,String b){
		String tmp[]=new String[a.length+1];
		for(int i=0;i<a.length;i++)
			tmp[i]=a[i];
		tmp[a.length]=b;
		return tmp;
	}
	public static String[] doubleLength(String[] t) {
		String tmp[]=new String[t.length*2];
		for(int i=0;i<t.length;i++)
			tmp[i]=t[i];
		return tmp;
	}
	public static IndexedString[] doubleLength(IndexedString[] is) {
		IndexedString tmp[]=new IndexedString[is.length*2];
		for(int i=0;i<is.length;i++)
			tmp[i]=is[i];
		return tmp;
	}

}
