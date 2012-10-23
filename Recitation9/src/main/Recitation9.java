package main;

import java.util.Scanner;

import bus.uigen.ObjectEditor;

import collections.AlignedShapeStack;
import collections.ShapeStack;

public class Recitation9 {

	public static void main(String[] args) {
		ShapeStack stack = new AlignedShapeStack(); // set up stack
		ObjectEditor.edit(stack); // call Object Editor on stack
		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.println("Please enter a keyword: pop, size, or triangle");
			String newLine = scanner.next();
			if (newLine.equals("pop")){
				stack.pop();
			}
			else if (newLine.equals("size")){
				System.out.println(stack.size());				
			}
			else if (newLine.equals("triangle")){
				System.out.println("Please enter a series of six integers");
				int x1 = scanner.nextInt();
				int y1 = scanner.nextInt();
				int x2 = scanner.nextInt();
				int y2 = scanner.nextInt();
				int x3 = scanner.nextInt();
				int y3 = scanner.nextInt();
				System.out.println("Thank you. Your triangle is done. Please refresh.");
				graphics.CartesianTriangle triangle = new graphics.CartesianTriangle(x1, y1, x2, y2, x3, y3);
				stack.push(triangle);
			}
			else if (newLine.equals("quit")){
				break;
			}
			else{
				System.out.println("Not a valid entry. Please try again.");
			}
		}
		//scanner.next();
		//scanner.nextInt();
		//"size" -> print size of stack
		//"pop" -> pop element off stack
		//"triangle -> create cartesianTriangle object using nextInt(); 6 times
			//to create a cartesian triangle 
			//push it onto stack
		//need to manually refresh OE to see changes (view-> refresh
		//Bonus Let users push lines, circles, ovals, etc. 
		
	}
}