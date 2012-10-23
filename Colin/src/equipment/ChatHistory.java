package equipment;

import graphics.Point;
import graphics.Points;
import input.StaticDynamicArray;

public class ChatHistory implements LabelCollections{
	Points p;
	String[] t;
	int length, start;
	public ChatHistory(Points p,String[] t){
		this.p=p;
		this.t=new String[10];
		for(int i=0;i<t.length;i++)
			add(t[i]);
	}
	@Override
	public int size(){
		return length;
	}
	@Override
	public void add(String a){
		if(length==t.length)
			StaticDynamicArray.doubleLength(t);
		t[length++]=a;
	}
	@Override
	public void removeF(){
		for(int i=0;i<length-1;i++)
			t[i]=t[i+1];
		start++;
		length--;
	}
	@Override
	public void removeL(){
		length--;
	}
	@Override
	public Labels getElementAt(int r){
		if(r<length)
			return new Label(new Point(p.getX(),p.getY()+(r+start)*17),t[r]);
		return null;
	}
}
