package composition;

import graphics.Oval;
import scenery.BridgeScenery;
import avatars.GuardAvatar;
import avatars.OvalStandingArea;

public class Scene implements Scenic {

	
	private GuardAvatar guard;
	private BridgeScenery bridge;
	private Oval GSA;
	private Oval KSA;

	public Scene() {
		guard = new avatars.GuardAvatar(285, 250);
		bridge = new scenery.BridgeScenery(0, 0);
		OvalStandingArea GuardStandingArea = new avatars.OvalStandingArea(385, 250);
		GSA = GuardStandingArea.standingArea();
		OvalStandingArea KnightStandingArea = new avatars.OvalStandingArea(285, 250);
		KSA = KnightStandingArea.standingArea();
		getGuard();
		getBridge();
		getGuardStandingArea();
		getKnightStandingArea();

	}

	public GuardAvatar getGuard() {
		// avatars.GuardAvatar guard = new avatars.GuardAvatar(0, 50);
		return guard;
	}

	public BridgeScenery getBridge() {
		// scenery.BridgeScenery bridge = new scenery.BridgeScenery(0,0);
		return bridge;
	}
	
	public Oval getKnightStandingArea() {
		return KSA;
	}
	
	public Oval getGuardStandingArea() {
		return GSA;
	}
}
