package scene;

import parts.SceneParts;
import avatar.NamedMovables;

public interface Scenes {
	public SceneParts[] getScenes();
	public NamedMovables getGuard();
	public void moveG();
}
