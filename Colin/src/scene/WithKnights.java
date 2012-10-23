package scene;

import graphics.Point;
import avatar.NamedMovableKnight;
import avatar.NamedMovables;
public class WithKnights extends WithoutKnights implements ScenesWithKnights{
	NamedMovables[] k;
	String[] n;
	public WithKnights(String[] n){
		super(n[0]);
		this.n=n;
		for(int i=1;i<n.length;i++)
			k[i]=new NamedMovableKnight(new Point(200-i*60,136),n[i]);
	}
	public NamedMovables[] getKnights(){
		return k;
	}
	public void moveK(){
		for(NamedMovables j:k)
			j.move();
	}
}
