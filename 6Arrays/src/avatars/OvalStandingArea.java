package avatars;

import main.Oval;

public class OvalStandingArea implements StandingArea {
	Oval standingArea;
	int x;
	int y;

	public OvalStandingArea(int startX, int startY) {
		x = startX;
		y = startY;
		standingArea = new main.AnOval(x, y + 120, 40, 20);
	}

	@Override
	public Oval standingArea() {
		return standingArea;
	}
}
