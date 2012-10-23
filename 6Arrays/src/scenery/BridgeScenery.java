package scenery;

import main.Label;

public class BridgeScenery implements Scenery {
	Label bridge;
	int startSceneX;
	int startSceneY;

	public BridgeScenery(int x, int y) {
		startSceneX = x;
		startSceneY = y;
		buildBridgeScenery();
	}

	public void buildBridgeScenery() {
		this.bridge = new main.ALabel(startSceneX, startSceneY, 1021, 651,
				"Hyrule", "BridgeBackground.jpg");
		// this.bridge = new main.ALabel(40, 30, 1021, 651,
		// "Hyrule","BridgeBackground.jpg");
	}

	@Override
	public Label getBackgroundBridge() {
		return bridge;
	}

	@Override
	public int getStartSceneX() {
		return startSceneX;
	}

	@Override
	public int getStartSceneY() {
		return startSceneY;
	}

	@Override
	public void setStartSceneX(int x) {
		startSceneX = startSceneX + x;
		buildBridgeScenery();

	}

	@Override
	public void setStartSceneY(int y) {
		startSceneY = startSceneY + y;
		buildBridgeScenery();

	}

}
