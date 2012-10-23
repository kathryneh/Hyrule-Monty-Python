package main;

import bus.uigen.ObjectEditor;
import collections.AlignedTriangleStack;
import collections.CorneredTriangleStack;
import collections.TransparentObjectStack;
import collections.TransparentStackSwapper;
import graphics.CartesianTriangle;
import graphics.Triangle;

public class TransparentStackSwapperTester implements Tester {

	public TransparentStackSwapperTester() {
		
	}
	
	public boolean test() {
		return new CorneredTriangleStackTester().test() &&
		       new AlignedTriangleStackTester().test();
	}
	
	public void displayTest() {
		TransparentObjectStack stackA = new CorneredTriangleStack();
		TransparentObjectStack stackB = new AlignedTriangleStack();
		
		for(int i = 0; !stackA.isFull(); i++) {
			stackA.push(createTriangle(i));
		}
		
		Triangle tri = createTriangle(stackA.size());
		tri.setX(tri.getX() + 270);
		tri.setY(tri.getY() - 50);
		stackB.push(tri);
		
		ObjectEditor.edit(new TransparentStackSwapper(stackA, stackB));
	}
	
	Triangle createTriangle(int i) {
		return new CartesianTriangle(50 - i * 10, 10 + 10 * i,
                20 - i * 20, 50 + 10 * i,
                70 + i * 5, 40 + 10 * i);
	}
}