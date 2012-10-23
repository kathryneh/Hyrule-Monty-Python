package avatars;

import graphics.Line;
import graphics.Oval;
import graphics.Text;

public class Avatar implements Avatarized{
	Oval head;
	Oval body;
	Line leftArm;
	Line rightArm;
	Line leftLeg;
	Line rightLeg;
	Text name;
	
	int xValue; 
	int yValue;
	
	int headHeight = 32;
	int bodyHeight = headHeight + headHeight * 2;
	int legStartY = bodyHeight - 6;
	int headWidth = 42;
	int bodyWidth = headWidth - 4;
	int armLength = 25;
	
	public Avatar(int x, int y){
		xValue = x; 
		yValue = y;
		buildAvatar();
	}
	@Override
	public Oval getHead() {
		return head;
	}

	@Override
	public Oval getBody() {
		return body;
	}

	@Override
	public Line getLeftArm() {
		return leftArm;
	}

	@Override
	public Line getRightArm() {
		return rightArm;
	}

	@Override
	public Line getLeftLeg() {
		return leftLeg;
	}

	@Override
	public Line getRightLeg() {
		return rightLeg;
	}

	@Override
	public Text getName() {
		return name;
	}

	@Override
	public int getX() {
		return xValue;
	}

	@Override
	public int getY() {
		return yValue;
	}

	@Override
	public void setX(int x) {
		xValue = x;
		buildAvatar();
	}

	@Override
	public void setY(int y) {
		yValue = y;
		buildAvatar();
	}

	@Override
	public void moveX(int x) {
		xValue = xValue + x;
	}

	@Override
	public void moveY(int y) {
		yValue = yValue + y;
	}

	@Override
	public void buildAvatar() {
		this.body = new graphics.Oval(xValue, yValue + headHeight,
				bodyWidth, headHeight * 2);
		//bodyOval = bodyOval.getOval();
		this.head = new graphics.Oval(xValue, yValue, headWidth,
				headHeight);
		//headOval = headOval.getOval();
		this.leftArm = new graphics.Line(xValue, yValue + headHeight * 2,
				armLength, armLength);
		//leftArmLine = leftArm.getLeftArm();
		this.rightArm = new graphics.Line(xValue + bodyWidth, yValue
				+ headHeight * 2, armLength, armLength);
		//rightArmLine = rightArm.getLeftArm();
		this.leftLeg = new graphics.Line(xValue + headWidth / 3, yValue
				+ bodyHeight, 1, 32);
		//leftLegLine = leftLeg.getLeg();
		this.rightLeg = new graphics.Line(xValue + (2 * headWidth / 3),
				yValue + bodyHeight, 1, 32);
		//rightLegLine = rightLeg.getLeg();
		//this.sword = new graphics.Line(xValue + armLength, yValue
		//		+ headHeight * 2 + armLength, 36, -38);
		//swordLine = sword.getSword();
		this.name = new graphics.Text(xValue, yValue-20, 30, 20, "Link");
		//nameText = name.getName();
	}

}
