package main;

import graphics.Triangle;
import collections.AlignedTriangleStack;
import collections.TransparentObjectStack;

public class AlignedTriangleStackTester extends TriangleStackTester {

	static final int NUM_ALIGNED_TRIANGLES = AlignedTriangleStack.CAPACITY;
	
	public AlignedTriangleStackTester() {
		super();
	}
	
	int numTriangles() {
		return NUM_ALIGNED_TRIANGLES;
	}
	
	TransparentObjectStack getStack() {
		return new AlignedTriangleStack();
	}
	
	public boolean test() {
		if(!super.test()) {
			return false;
		}
		
		TransparentObjectStack stack = getStack();
		
		Triangle curr = createTriangle(0);
		int x = curr.getX();
		int y = curr.getY();
		stack.push(curr);
		
		if(curr.getX() != x || curr.getY() != y) {
			System.err.println("Triangle 0 was incorrectly moved from (" + x + "," + y + ") " +
					"to (" + curr.getX() + "," + curr.getY() + ")");
			return false;
		}
		
		Triangle prev;
		int[] xValues = new int[numTriangles()];
		int[] yValues = new int[numTriangles()];
		xValues[0] = curr.getX();
		yValues[0] = curr.getY();
		
		for(int i = 1; i < numTriangles(); i++) {
			prev = (Triangle) stack.peek();
			curr = createTriangle(i);
			stack.push(curr);
			
			int currX = prev.getX();
			int currY = prev.getY() + prev.getHeight();
			
			if(curr.getX() != currX || curr.getY() != currY) {
				System.err.println("Triangle " + i + " incorrectly placed at (" +
						curr.getX() + "," + curr.getY() + ") instead of (" +
						currX + "," + currY + ")");
				return false;
			}
			
			xValues[i] = currX;
			yValues[i] = currY;
		}
		
		for(int i = 0; i < numTriangles(); i++) {
			curr = (Triangle) stack.peek();
			
			int currX = xValues[xValues.length - 1 - i];
			int currY = yValues[yValues.length - 1 - i];
			
			if(curr.getX() != currX || curr.getY() != currY) {
				System.err.println("Before pop #" + (i + 1) + ", top triangle was incorrectly " +
						"moved from (" + currX + "," + currY + ") to (" +
						curr.getX() + "," + curr.getY() + ")");
				return false;
			}
			
			stack.pop();
		}
		
		return true;
	}
}