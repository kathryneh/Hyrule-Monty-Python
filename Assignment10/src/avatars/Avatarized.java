package avatars;

import graphics.Line;
import graphics.Oval;
import graphics.Text;

public interface Avatarized {

	public Oval getHead();

	public Oval getBody();

	public Line getLeftArm();

	public Line getRightArm();

	public Line getLeftLeg();

	public Line getRightLeg();

	public Text getName();

	public int getX();

	public int getY();

	public void setX(int x);

	public void setY(int y);
	
	public void moveX(int x);
	
	public void moveY(int y);
	
	public void buildAvatar();
}

