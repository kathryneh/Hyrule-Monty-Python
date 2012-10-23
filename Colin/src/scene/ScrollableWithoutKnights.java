package scene;

import parts.SceneParts;

public class ScrollableWithoutKnights extends WithoutKnights implements ScrollableScenes{
	public ScrollableWithoutKnights(String[] n) {
		super(n[0]);
	}
	protected void scroll(int i,boolean b){
		if(b){
			g.moveH(-i);
			for(SceneParts a:getScenes())
				a.scrollH(i);
		}
		else{
			for(SceneParts a:getScenes())
				a.scrollV(i);
					g.moveV(-i);
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
