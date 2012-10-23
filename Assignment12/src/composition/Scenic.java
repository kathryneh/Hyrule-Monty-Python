package composition;

import avatars.GuardAvatar;
import graphics.Oval;
import scenery.BridgeScenery;

public interface Scenic {

	public BridgeScenery getBridge();
	public Oval getKnightStandingArea();
	public Oval getGuardStandingArea();
	public GuardAvatar getGuard();
}
