package composition;

import main.Oval;
import scenery.BridgeScenery;
import util.annotations.Visible;
import avatars.GuardAvatar;
import avatars.KnightAvatar;
import avatars.OvalStandingArea;

public class ScrollableComposition implements Composition {
	private KnightAvatar knight;
	private GuardAvatar guard;
	private BridgeScenery bridge;
	private Oval SA;
	int scrollX = 0;
	int scrollY = 0;

	public ScrollableComposition() {
		guard = new avatars.GuardAvatar(285 + scrollX, 250 + scrollY);
		knight = new avatars.KnightAvatar(285 + scrollX, 250 + scrollY);
		bridge = new scenery.BridgeScenery(0 + scrollX, 0 + scrollY);
		OvalStandingArea standingArea = new avatars.OvalStandingArea(
				285 + scrollX, 250 + scrollY);
		SA = standingArea.standingArea();
		getKnight();
		getGuard();
		getBridge();
		getStandingArea();

	}

	public void buildScrollableComposition() {
		guard = new avatars.GuardAvatar(285 + scrollX, 250 + scrollY);
		knight = new avatars.KnightAvatar(285 + scrollX, 250 + scrollY);
		bridge = new scenery.BridgeScenery(0 + scrollX, 0 + scrollY);
		OvalStandingArea standingArea = new avatars.OvalStandingArea(
				285 + scrollX, 250 + scrollY);
		SA = standingArea.standingArea();
		getKnight();
		getGuard();
		getBridge();
		getStandingArea();
	}

	public void setScrollX(int newVal) {
		scrollX = newVal + scrollX;
		buildScrollableComposition();

	}

	public void setScrollY(int newVal) {
		scrollY = newVal + scrollY;
		buildScrollableComposition();
	}

	@Override
	@Visible(false)
	public KnightAvatar getKnight() {
		// avatars.KnightAvatar knight = new avatars.KnightAvatar(0, 50);
		return knight;
	}

	@Override
	public GuardAvatar getGuard() {
		// avatars.GuardAvatar guard = new avatars.GuardAvatar(0, 50);
		return guard;
	}

	@Override
	public BridgeScenery getBridge() {
		// scenery.BridgeScenery bridge = new scenery.BridgeScenery(0,0);
		return bridge;
	}

	@Override
	public Oval getStandingArea() {
		return SA;
	}
}
