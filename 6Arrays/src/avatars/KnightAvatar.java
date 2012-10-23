package avatars;

import bodyparts.Arm;
import bodyparts.Leg;
import bodyparts.Name;
import bodyparts.Ovals;
import bodyparts.Shield;
import bodyparts.Sword;
import util.annotations.Visible;
import main.Line;
import main.Oval;
import main.Rectangle;
import main.TextBox;

public class KnightAvatar implements Avatar {
	int startX;
	int startY;
	int initialX;
	int initialY;
	Oval headOval;
	Ovals body;
	Ovals head;
	Oval bodyOval;
	Rectangle shieldRectangle;
	Sword sword;
	Shield shield;
	Name name;
	// Line leftArm;
	Arm leftArm;
	Arm rightArm;
	Leg leftLeg;
	Leg rightLeg;
	Line rightArmLine;
	Line leftLegLine;
	Line rightLegLine;
	Line swordLine;
	// Oval SA;
	TextBox nameText;
	Line leftArmLine;

	// these define all of the ints
	int headHeight = 32;
	int bodyHeight = headHeight + headHeight * 2;
	int legStartY = bodyHeight - 6;
	int headWidth = 42;
	int bodyWidth = headWidth - 4;
	int armLength = 25;
	int legLength;
	int movedX;
	int movedY;

	public KnightAvatar(int x, int y) {
		startX = x;
		startY = y;
		buildKnightAvatar();

	}

	private void buildKnightAvatar() {

		this.body = new bodyparts.Ovals(startX, startY + headHeight,
				bodyWidth, headHeight * 2);
		bodyOval = body.getOval();
		this.head = new bodyparts.Ovals(startX, startY, headWidth,
				headHeight);
		headOval = head.getOval();
		this.leftArm = new bodyparts.Arm(startX, startY + headHeight * 2,
				armLength, armLength);
		leftArmLine = leftArm.getLeftArm();
		this.rightArm = new bodyparts.Arm(startX + bodyWidth, startY
				+ headHeight * 2, armLength, armLength);
		rightArmLine = rightArm.getLeftArm();
		this.leftLeg = new bodyparts.Leg(startX + headWidth / 3, startY
				+ bodyHeight, 1, 32);
		leftLegLine = leftLeg.getLeg();
		this.rightLeg = new bodyparts.Leg(startX + (2 * headWidth / 3),
				startY + bodyHeight, 1, 32);
		rightLegLine = rightLeg.getLeg();
		this.sword = new bodyparts.Sword(startX + armLength, startY
				+ headHeight * 2 + armLength, 36, -38);
		swordLine = sword.getSword();
		this.shield = new bodyparts.Shield(startX + armLength, startY
				+ (headHeight * 2 - armLength), 36, 38);
		shieldRectangle = shield.getRectangle();
		this.name = new bodyparts.Name(startX, startY-20, 30, 20, "Link");
		nameText = name.getName();
		// OvalStandingArea standingArea = new avatars.OvalStandingArea(startX,
		// startY);
		// SA = standingArea.standingArea();
	}

	
	@Override
	public Oval getHead() {
		return headOval;
	}

	
	@Override
	public Oval getBody() {
		return bodyOval;
	}

	
	@Override
	public Line getLeftArm() {
		return leftArmLine;
	}


	@Override
	public Line getRightArm() {
		return rightArmLine;
	}


	@Override
	public Line getLeftLeg() {
		return leftLegLine;
	}


	@Override
	public Line getRightLeg() {
		return rightLegLine;
	}


	@Override
	@Visible(false)
	public Rectangle getShield() {
		return null;
	}


	@Override
	public Line getSword() {
		return swordLine;
	}


	@Override
	public TextBox getName() {
		return nameText;
	}


	@Override
	public int getX() {
		return startX;
	}


	@Override
	public int getY() {
		return startY;
	}


	@Override
	public void setX(int moveX) {
		startX = startX + moveX;
		buildKnightAvatar();
	}


	@Override
	public void setY(int moveY) {
		startY = startY + moveY;
		buildKnightAvatar();
	}

	// public Oval getStandingArea() {
	// return SA;
	// }

	public void testAvatar(int startX, int startY, int moveX, int moveY) {
		// the get method is the changed value; needs to equal the initial value
		// + the movement.
		boolean passed = true;
		if (leftArm.getStartX() == startX + moveX) {
			System.out.println("Passed Left Arm X Test.");
		} else {
			passed = false;
		}
		if (leftArm.getStartY() == startY + headHeight * 2 + moveY) {
			System.out.println("Passed Left Arm Y Test.");
		} else {
			passed = false;
		}
		if (rightArm.getStartX() == startX + bodyWidth + moveX) {
			System.out.println("Passed Right Arm X Test.");
		} else {
			passed = false;
		}
		if (rightArm.getStartY() == startY + headHeight * 2 + moveY) {
			System.out.println("Passed Right Arm Y Test.");
		} else {
			passed = false;
		}
		if (leftLeg.getStartX() == startX + headWidth / 3 + moveX) {
			System.out.println("Passed Left Leg X Test.");
		} else {
			passed = false;
		}
		if (leftLeg.getStartY() == startY + bodyHeight + moveY) {
			System.out.println("Passed Left Leg Y Test.");
		} else {
			passed = false;
		}
		if (rightLeg.getStartX() == startX + (2 * headWidth / 3) + moveX) {
			System.out.println("Passed Right Leg X Test.");
		} else {
			passed = false;
		}
		if (rightLeg.getStartY() == startY + bodyHeight + moveY) {
			System.out.println("Passed Right Leg Y Test.");
		} else {
			passed = false;
		}
		if (body.getStartX() == startX + moveX) {
			System.out.println("Passed Body X Test.");
		} else {
			passed = false;
		}
		if (body.getStartY() == startY + headHeight + moveY) {
			System.out.println("Passed Body Y Test.");
		} else {
			passed = false;
		}
		if (sword.getStartX() == startX + armLength + moveX) {
			System.out.println("Passed Sword X Test.");
		} else {
			passed = false;
		}
		if (sword.getStartY() == startY + headHeight * 2 + armLength + moveY) {
			System.out.println("Passed Sword Y Test.");
		} else {
			passed = false;
		}
		if (head.getStartX() == startX + moveX) {
			System.out.println("Passed Head X Test.");
		} else {
			passed = false;
		}
		if (head.getStartY() == startY + moveY) {
			System.out.println("Passed Head Y Test.");
		} else {
			passed = false;
		}
		if (name.getStartX() == startX + moveX) {
			System.out.println("Passed Name X Test.");
		} else {
			passed = false;
		}
		if (name.getStartY() == startY - 20 + moveX) {
			System.out.println("Passed Name Y Test.");
		}
		if (!passed) {
			System.out.println("Test failed.");
		} else {
			System.out.println("All Tests Passed");
		}
	}

}
