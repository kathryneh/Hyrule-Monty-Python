package scene;

import parts.GorgeWithBridge;
import parts.SceneParts;
import parts.StandingArea;
import graphics.Point;
import avatar.NamedMovableGuard;
import avatar.NamedMovables;

public class WithoutKnights implements Scenes{
	NamedMovables g;
	public WithoutKnights(String n){
		g=new NamedMovableGuard(new Point(200,136),n);
	}
	@Override
	public NamedMovables getGuard() {
		return g;
	}
	@Override
	public void moveG(){
		g.move();
	}
	@Override
	public SceneParts[] getScenes() {
		return new SceneParts[]{new GorgeWithBridge(),new StandingArea()};
	}
}
