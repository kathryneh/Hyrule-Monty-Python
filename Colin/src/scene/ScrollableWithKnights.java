package scene;

import parts.SceneParts;
import avatar.NamedMovables;

public class ScrollableWithKnights extends WithKnights implements ScenesWithKnights,ScrollableScenes{

	public ScrollableWithKnights(String[] n) {
		super(n);
	}
	protected void scroll(int i,boolean b){
		if(b){
			g.moveH(-i);
			for(SceneParts a:getScenes())
				a.scrollH(i);
					for(NamedMovables j:k)
						j.moveH(-i);
		}
		else{
			for(SceneParts a:getScenes())
				a.scrollH(i);
					g.moveH(-i);
					for(NamedMovables j:k)
						j.moveH(-i);
		}
	}
	public void scrollXL(){
		scroll(-20,true);
	}
	public void scrollYU(){
		scroll(-20,false);
	}
	public void scrollXR(){
		scroll(20,true);
	}
	public void scrollYD(){
		scroll(20,false);
	}
}