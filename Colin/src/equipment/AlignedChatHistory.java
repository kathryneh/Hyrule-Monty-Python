package equipment;

import graphics.Point;
import graphics.Points;

public class AlignedChatHistory extends ChatHistory{
	public AlignedChatHistory(Points p, String[] t) {
		super(p,t);
	}
	public void add(String a, Point p){
		super.add(a);
		this.p=new Point(p.getX(),this.p.getY());
	}
}
