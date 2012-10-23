package main;

import bus.uigen.ObjectEditor;
import collections.TransparentObjectStack;
import collections.TriangleStack;
import graphics.CartesianTriangle;
import graphics.Triangle;

public class TriangleStackTester implements Tester {

	static final int NUM_TRIANGLES = 6;
	
	private TransparentObjectStack stack;
	
	public TriangleStackTester() {
		stack = getStack();
	}
	
	int numTriangles() {
		return NUM_TRIANGLES;
	}
	
	TransparentObjectStack getStack() {
		return new TriangleStack(numTriangles());
	}
	
	public boolean test() {
		Triangle[] triangles = new Triangle[numTriangles()];
		
		if(stack.size() != 0) {
			System.err.println("Initial stack size is nonzero");
			return false;
		}
		if(!stack.isEmpty()) {
			System.err.println("Newly created stack is not empty");
			return false;
		}
		
		stack.push(new Object());
		if(!stack.isEmpty() || stack.size() != 0) {
			System.err.println("Stack allowed addition of non-Triangle object");
			return false;
		}
		
		for(int i = 0; i < triangles.length; i++) {
			triangles[i] = createTriangle(i);
			stack.push(triangles[i]);
			if(stack.size() != (i + 1)) {
				System.err.println("Stack size is " + stack.size() + " after " +
						(i + 1) + " pushes");
				return false;
			}
			if(stack.isEmpty()) {
				System.err.println("Stack is incorrectly empty after " + (i + 1) + " pushes");
				return false;
			}
			if(stack.isFull() && i < triangles.length - 1) {
				System.err.println("Stack is incorrectly full after " + (i + 1) + " pushes");
				return false;
			}
			if(!stack.isFull() && i == triangles.length - 1) {
				System.err.println("Full stack is incorrectly thought not full");
				return false;
			}
			
			for(int j = 0; j <= i; j++) {
				if(stack.get(j) != triangles[j]) {
					System.err.println("After " + (i + 1) + " pushes, " +
							"triangle at index " + j + " is at wrong position");
					return false;
				}
			}
		}
		
		stack.push(createTriangle(numTriangles()));
		if(stack.size() > triangles.length) {
			System.err.println("Stack allowed a push beyond its capacity");
			return false;
		}
		if(!stack.isFull()) {
			System.err.println("Full stack is incorrectly thought not full");
			return false;
		}
		
		for(int i = 0; i < triangles.length; i++) {
			stack.pop();
			if(stack.size() != triangles.length - 1 - i) {
				System.out.println("Incorrect size after " + (i + 1) + " pops. " +
						"Expected: " + (triangles.length - i - 1) + ", Got: " + stack.size());
				return false;
			}
			for(int j = 0; j < triangles.length - 1 - i; j++) {
				if(stack.get(j) != triangles[j]) {
					System.err.println("After " + (i + 1) + " pops, " +
							"triangle at index " + j + " is at wrong position");
					return false;
				}
			}
		}
		
		if(!stack.isEmpty()) {
			System.err.println("Stack not considered empty after all elements removed");
			return false;
		}
		
		try {
			stack.pop();
			stack.pop();
		} catch(Exception e) {
			System.err.println("Popping from an empty stack caused an Exception:\n");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void displayTest() {
		TransparentObjectStack stack = getStack();
		for(int i = 0; i < numTriangles(); i++) {
			stack.push(createTriangle(i));
		}
		ObjectEditor.edit(stack);
	}
	
	Triangle createTriangle(int i) {
		return new CartesianTriangle(100 - i * 10, 10 + 10 * i,
                70 - i * 20, 50 + 10 * i,
                120 + i * 5, 40 + 10 * i);
	}
}