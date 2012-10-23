package main;

import graphics.Triangle;
import collections.CorneredTriangleStack;
import collections.TransparentObjectStack;

public class CorneredTriangleStackTester extends TriangleStackTester {

	static final int NUM_CORNERED_TRIANGLES = CorneredTriangleStack.CAPACITY;
	
	public CorneredTriangleStackTester() {
		super();
	}
	
	int numTriangles() {
		return NUM_CORNERED_TRIANGLES;
	}
	
	TransparentObjectStack getStack() {
		return new CorneredTriangleStack();
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
		
		for(int i = 1; i < numTriangles(); i++) {
			curr = createTriangle(i);
			stack.push(curr);
			
			if(curr.getX() != x || curr.getY() != y) {
				System.err.println("Triangle " + i + " incorrectly placed at (" +
						curr.getX() + "," + curr.getY() + ") instead of (" +
						x + "," + y + ")");
				return false;
			}
		}
		
		for(int i = 0; i < numTriangles(); i++) {
			curr = (Triangle) stack.peek();
			
			if(curr.getX() != x || curr.getY() != y) {
				System.err.println("Before pop #" + (i + 1) + ", top triangle was incorrectly " +
						"moved from (" + x + "," + y + ") to (" +
						curr.getX() + "," + curr.getY() + ")");
				return false;
			}
			
			stack.pop();
		}
		
		return true;
	}
}