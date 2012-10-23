package main;

/**
 * If this code runs successfully, your implementation is correct.
 * DO NOT EDIT THIS CLASS.
 */
public class Recitation7 {

	public static void main(String[] args) {
		Tester tester = new TriangleStackTester();
		//Tester tester = new AlignedTriangleStackTester();
		//Tester tester = new CorneredTriangleStackTester();
		//Tester tester = new TransparentStackSwapperTester();
		if(tester.test()) {
			System.out.println("All tests passed.");
			tester.displayTest();
		}
	}
}