package input;


import token.Tokens;

public class Transpose{
	public static char charType(char a){
		if(a==32)
			return 's';//space
		if(a==34)
			return 'q';//quote
		if(a==43)
			return 'p';//plus
		if(a==45)
			return 'm';//minus
		if(a<58&&a>47)
			return 'n';//number
		if(a>96&&a<123)
			return 'l';//lowercase number
		if(a>64&&a<91)
			return 'u';//uppercase number
		return 'x';//all else
	}
	//transposes args[0] into an array of Tokens	
	public static Tokens[] transpose(String a,Tokens[] z,boolean ß){
		if(a.length()==0)
			return z;
		if(charType(a.charAt(0))=='s'||charType(a.charAt(0))=='x'){
			if(charType(a.charAt(0))=='x')
				z=StaticDynamicArray.add(z,"Error",a.substring(0,1));
			return transpose(a.substring(1),z,ß);
		}
		else{
			if(charType(a.charAt(0))=='q'){
				for(int i=1;i<a.length();i++){
					if(charType(a.charAt(i))=='q'){
						z=StaticDynamicArray.add(z,"Quoted String",a.substring(1,i));
						return transpose(a.substring(i+1),z,ß);
					}
				}
				z=StaticDynamicArray.add(z,"0",null);//'0': failure to end quote
				return z;
			}
			if(charType(a.charAt(0))=='p'){
				z=StaticDynamicArray.add(z,"Plus",null);
				return transpose(a.substring(1),z,ß);
			}
			if(charType(a.charAt(0))=='m'){
				z=StaticDynamicArray.add(z,"Minus",null);
				return transpose(a.substring(1),z,ß);
			}
			if(charType(a.charAt(0))=='n')
				for(int i=0;i<a.length();i++){
					if(charType(a.charAt(i))=='x'){
						z=StaticDynamicArray.add(z,"Error",a.substring(i,i+1));
						if(i!=a.length()-1)
							a=a.substring(0,i)+a.substring(i+1);
						else{
							z=StaticDynamicArray.add(z,"Number",a.substring(0,i));
							return z;
						}
					}
					if(charType(a.charAt(i))!='n'){
						z=StaticDynamicArray.add(z,"Number",a.substring(0,i));
						return transpose(a.substring(i),z,ß);
					}
					if(i==a.length()-1){
						z=StaticDynamicArray.add(z,"Number",a);
						return z;
					}
				}
			if(charType(a.charAt(0))=='l'||charType(a.charAt(0))=='u'){
				if(ß){
					if(a.length()>=6){
						if(a.substring(0,6).equals("failed")){
							z=StaticDynamicArray.add(z,"CFailed","failed");
							if(a.length()==6)
								return z;
							else
								return transpose(a.substring(6),z,ß);
						}
						else if(a.substring(0,6).equals("passed")){
							z=StaticDynamicArray.add(z,"CPassed","passed");
							if(a.length()==6)
								return z;
							else
								return transpose(a.substring(6),z,ß);
						}
						else if(a.substring(0,6).equals("scroll")){
							z=StaticDynamicArray.add(z,"CScroll","scroll");
							if(a.length()==6)
								return z;
							else
								return transpose(a.substring(6),z,ß);
						}
					}
					else if(a.length()>=4){
						if(a.substring(0,3).equals("redo")){
							z=StaticDynamicArray.add(z,"CRedo","redo");
							if(a.length()==4)
								return z;
							else
								return transpose(a.substring(4),z,ß);
						}
						else if(a.substring(0,4).equals("move")){
							z=StaticDynamicArray.add(z,"CMove","move");
							if(a.length()==4)
								return z;
							else
								return transpose(a.substring(4),z,ß);
						}
						else if(a.substring(0,4).equals("undo")){
							z=StaticDynamicArray.add(z,"CUndo","undo");
							if(a.length()==4)
								return z;
							else
								return transpose(a.substring(4),z,ß);
						}
					}
					else if(a.length()>=3){
						if(a.substring(0,3).equals("say")){
							z=StaticDynamicArray.add(z,"CSay","say");
							if(a.length()==3)
								return z;
							else
								return transpose(a.substring(3),z,ß);
						}
					}
					else if(a.length()>=2){
						if(a.substring(0,2).equals("sy")){
							z=StaticDynamicArray.add(z,"CSay","sy");
							if(a.length()==2)
								return z;
							else
								return transpose(a.substring(2),z,ß);
						}
						else if(a.substring(0,2).equals("un")){
							z=StaticDynamicArray.add(z,"CUndo","un");
							if(a.length()==2)
								return z;
							else
								return transpose(a.substring(2),z,ß);
						}
						else if(a.substring(0,2).equals("sc")){
							z=StaticDynamicArray.add(z,"CScroll","sc");
							if(a.length()==2)
								return z;
							else
								return transpose(a.substring(2),z,ß);
						}
						else if(a.substring(0,2).equals("mv")){
							z=StaticDynamicArray.add(z,"CMove","mv");
							if(a.length()==2)
								return z;
							else
								return transpose(a.substring(2),z,ß);
						}
						else if(a.substring(0,2).equals("rd")){
							z=StaticDynamicArray.add(z,"CRedo","rd");
							if(a.length()==2)
								return z;
							else
								return transpose(a.substring(2),z,ß);
						}
						else if(a.substring(0,2).equals("ps")){
							z=StaticDynamicArray.add(z,"CPassed","ps");
							if(a.length()==2)
								return z;
							else
								return transpose(a.substring(2),z,ß);
						}
						else if(a.substring(0,2).equals("fl")){
							z=StaticDynamicArray.add(z,"CFailed","fl");
							if(a.length()==2)
								return z;
							else
								return transpose(a.substring(2),z,ß);
						}
					}
				}
				for(int i=0;i<a.length();i++){
					if(charType(a.charAt(i))=='x'){
						z=StaticDynamicArray.add(z,"Error",a.substring(i,i+1));
						if(i!=a.length()-1)
							a=a.substring(0,i)+a.substring(i+1);
						else{
							z=StaticDynamicArray.add(z,"Command",a.substring(0,i));
							return z;
						}
					}
					if(charType(a.charAt(i))!='l'&&charType(a.charAt(i))!='u'){
						z=StaticDynamicArray.add(z,"Command",a.substring(0,i));//'c' for command
						return transpose(a.substring(i),z,ß);
					}
					if(i==a.length()-1){
						z=StaticDynamicArray.add(z,"Command",a);
						return z;
					}
				}
			}
			return z;
		}
	}
}
