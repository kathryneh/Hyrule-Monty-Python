package scenery;

import graphics.Label;

public interface Scenery {
	public Label getBackgroundBridge();

	public int getStartSceneX();

	public int getStartSceneY();

	public void setStartSceneX(int x);

	public void setStartSceneY(int y);
}
