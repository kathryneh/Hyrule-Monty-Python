package parts;

import graphics.Line;
import graphics.Point;
import graphics.Shapes;

public class GorgeWithBridge extends Part implements SceneParts {
	@Override
	public Shapes[] getShapes() {
		return new Shapes[]{new Line(-40,-40,new Point(280+super.x,60+super.y)),new Line(-40,40,new Point(280+super.x,300+super.y)),new Line(40,40,new Point(440+super.x,300+super.y)),new Line(40,-40,new Point(440+super.x,60+super.y)),new Line(0,240,new Point(280+super.x,60+super.y)),new Line(0,240,new Point(440+super.x,60+super.y)),new Line(200,0,new Point(260+super.x,230+super.y)),new Line(200,0,new Point(260+super.x,260+super.y))};
	}
}