package avatars;

import graphics.Oval;

public class OvalStandingArea implements StandingArea {
	private Oval standingArea;
	private int x;
	private int y;

	public OvalStandingArea(int startX, int startY) {
		x = startX;
		y = startY;
		standingArea = new graphics.Oval(x, y + 120, 40, 20);
	}

	@Override
	public Oval standingArea() {
		return standingArea;
	}
}
