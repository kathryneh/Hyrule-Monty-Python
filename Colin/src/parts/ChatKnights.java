package parts;

import input.IndexedStrings;
import avatar.NamedChatKnight;
import avatar.NamedChatAvatars;
import graphics.Point;

public class ChatKnights extends Part implements ChatKnightParts{
	NamedChatAvatars[] k;
	IndexedStrings[] is;
	Point p;
	public ChatKnights(Point p,String[] k,IndexedStrings[] is){
		this.is=is;
		this.p=p;
		this.k=new NamedChatAvatars[k.length];
		for(int i=0;i<k.length;i++){
			String[] a=new String[is.length];
			for(int j=0;j<is.length;j++){
				if(is[j].getIndex()==i)
					a[j]=is[j].getString();
				else
					a[j]="";
			}
			this.k[i]=new NamedChatKnight(new Point(p.getX()+60*i,p.getY()),k[i],a);
		}
	}
	@Override
	public NamedChatAvatars[] getChatKnights(){
		return k;
	}
	@Override
	public void move(){
		for(NamedChatAvatars j:k)
			j.move();
	}
	protected void remove(boolean b){
		int j;
		if(b)
			j=1;
		else
			j=0;
		NamedChatAvatars[] tmp=new NamedChatAvatars[k.length-1];
		for(int i=0;i<k.length-1;i++)
			tmp[i]=k[i+j];
		k=tmp;
	}
	@Override
	public void removeF(){
		remove(true);
	}
	@Override
	public void removeL(){
		remove(false);
	}
	@Override
	public void scrollH(int n){
		for(NamedChatAvatars j:k)
			j.moveH(n);
	}
	@Override
	public void scrollV(int n){
		for(NamedChatAvatars j:k)
			j.moveV(n);
	}
}
