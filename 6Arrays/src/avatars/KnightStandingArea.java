package avatars;

import main.Oval;

public class KnightStandingArea implements StandingArea {
	public Oval standingArea;
	int startX;
	int startY;

	public KnightStandingArea(int x, int y) {
		x = startX;
		y = startY;
		standingArea = new main.AnOval(x, y + 80, 40, 40);
	}

	@Override
	public Oval standingArea() {
		return standingArea;
	}

}
