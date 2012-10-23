package avatar;

import equipment.AlignedChatHistory;
import graphics.Point;

public class NamedChatGuard extends NamedMovableGuard implements NamedChatAvatars{
	String[] h;
	public NamedChatGuard(Point l,String n,String[] h){
		super(new Point(l.getX(),l.getY()),n);
		this.h=h;
	}
	@Override
	public AlignedChatHistory getChat(){
		return new AlignedChatHistory(new Point(l.getX(),l.getY()-(h.length+1)*17),h);//Point incremented to account for shift in constructor
	}
	@Override
	public void removeF() {
		String[] tmp=new String[h.length-1];
		for(int i=0;i<h.length-1;i++)
			tmp[i]=h[i+1];
		h=tmp;
	}
	@Override
	public void removeL() {
		for(int i=h.length-1;i>-1;i--)
			if(h[i].length()!=0){
				h[i]="";
				break;
			}
	}
}
