package parts;

import input.BooleanStrings;
import graphics.Point;
import avatar.NamedMovableGuard;
import avatar.NamedMovableKnight;
import avatar.NamedMovables;

public class FallenMovables extends Part implements FallenMovableParts{
	NamedMovables[] k;
	Point p;
	public FallenMovables(Point p,BooleanStrings[] k){
		this.p=p;
		this.k=new NamedMovables[k.length];
		for(int i=0;i<k.length;i++){
			if(!k[i].getBoole())
				this.k[i]=new NamedMovableGuard(new Point(p.getX()+60*i,p.getY()),k[i].getString());
			else
				this.k[i]=new NamedMovableKnight(new Point(p.getX()+60*i,p.getY()),k[i].getString());
		}
	}
	@Override
	public NamedMovables[] getAvatars(){
		return k;
	}
	@Override
	public void move(){
		for(NamedMovables j:k)
			j.move();
	}
	protected void remove(boolean b){
		int j;
		if(b)
			j=1;
		else
			j=0;
		NamedMovables[] tmp=new NamedMovables[k.length-1];
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
		for(NamedMovables j:k)
			j.moveH(n);
	}
	@Override
	public void scrollV(int n){
		for(NamedMovables j:k)
			j.moveV(n);
	}
}
