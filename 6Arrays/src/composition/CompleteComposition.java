package composition;

import main.Oval;
import scenery.BridgeScenery;
import avatars.GuardAvatar;
import avatars.KnightAvatar;
import avatars.OvalStandingArea;

public class CompleteComposition implements Composition {
	private KnightAvatar knight;
	private GuardAvatar guard;
	private BridgeScenery bridge;
	private Oval SA;

	public CompleteComposition() {
		guard = new avatars.GuardAvatar(285, 250);
		knight = new avatars.KnightAvatar(285, 250);
		bridge = new scenery.BridgeScenery(0, 0);
		OvalStandingArea standingArea = new avatars.OvalStandingArea(285, 250);
		SA = standingArea.standingArea();
		getKnight();
		getGuard();
		getBridge();
		getStandingArea();

	}

	@Override
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
