package composition;

import main.Oval;
import scenery.BridgeScenery;
import avatars.GuardAvatar;
import avatars.KnightAvatar;

public interface Composition {
	public KnightAvatar getKnight();

	public GuardAvatar getGuard();

	public BridgeScenery getBridge();

	public Oval getStandingArea();
}
