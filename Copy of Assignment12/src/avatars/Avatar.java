package avatars;

import graphics.Line;
import graphics.Oval;
import graphics.Text;

public abstract class Avatar implements Avatarized{
	protected Oval head;
	protected Oval body;
	protected Line leftArm;
	protected Line rightArm;
	protected Line leftLeg;
	protected Line rightLeg;
	protected Text name;
	protected String label;
	
	protected int xValue; 
	protected int yValue;
	
	protected int headHeight = 32;
	protected int bodyHeight = headHeight + headHeight * 2;
	protected int legStartY = bodyHeight - 6;
	protected int headWidth = 42;
	protected int bodyWidth = headWidth - 4;
	protected int armLength = 25;
	
	public Avatar(int x, int y, String name){
		xValue = x; 
		yValue = y;
		label = name;
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
		//buildAvatar();
		body.setX(xValue);
		head.setX(xValue);
		leftArm.setX(xValue);
		rightArm.setX(xValue + bodyWidth);
		leftLeg.setX(xValue + headWidth / 3);
		rightLeg.setX(xValue + (2 * headWidth / 3));
		name.setX(xValue);
	
	}

	@Override
	public void setY(int y) {
		yValue = y;
		body.setY(yValue + headHeight);
		head.setY(yValue);
		leftArm.setY(yValue + headHeight * 2);
		rightArm.setY(yValue + headHeight * 2);
		leftLeg.setY(yValue + bodyHeight);
		rightLeg.setY(yValue + bodyHeight);
		name.setY(yValue-20);
	}

	//@Override
	//public void moveX(int x) {
	//	xValue = xValue + x;
	//}

	//@Override
	//public void moveY(int y) {
	//	yValue = yValue + y;
	//}

	@Override
	public void buildAvatar() {
		this.body = new graphics.Oval(xValue, yValue + headHeight,
				bodyWidth, headHeight * 2);
		this.head = new graphics.Oval(xValue, yValue, headWidth,
				headHeight);
		this.leftArm = new graphics.Line(xValue, yValue + headHeight * 2,
				armLength, armLength);
		this.rightArm = new graphics.Line(xValue + bodyWidth, yValue
				+ headHeight * 2, armLength, armLength);
		this.leftLeg = new graphics.Line(xValue + headWidth / 3, yValue
				+ bodyHeight, 1, 32);
		this.rightLeg = new graphics.Line(xValue + (2 * headWidth / 3),
				yValue + bodyHeight, 1, 32);
		this.name = new graphics.Text(xValue, yValue-20, 30, 20, label);
		
	}

}
