package parts;

import graphics.Point;
import graphics.Rectangle;
import graphics.Shapes;

public class StandingArea extends Part implements SceneParts {
	@Override
	public Shapes[] getShapes() {
		return new Shapes[]{new Rectangle(55,30,new Point(135+super.x,230+super.y)),new Rectangle(55,30,new Point(195+super.x,230+super.y))};
	}
}