package avatars;

import main.Line;
import main.Oval;
import main.Rectangle;
import main.TextBox;

public interface Avatar {
	public Oval getHead();

	public Oval getBody();

	public Line getLeftArm();

	public Line getRightArm();

	public Line getLeftLeg();

	public Line getRightLeg();

	public Rectangle getShield();

	public Line getSword();

	public TextBox getName();

	public int getX();

	public int getY();

	public void setX(int moveX);

	public void setY(int moveY);
	// public Oval getStandingArea();
	// public void setMoveX(int x);
	// public void setMoveY(int x);
	// public int getMoveX();
	// public int getMoveY();
	// public void testAvatar(int x, int y, int z, int m);
}