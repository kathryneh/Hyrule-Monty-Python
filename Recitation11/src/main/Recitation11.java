package main;

import java.util.Scanner;

import bus.uigen.ObjectEditor;
import collections.ObservableAlignedShapeStack;
import collections.ShapeStack;
import graphics.CartesianCircle;
import graphics.CartesianLine;
import graphics.CartesianOval;
import graphics.CartesianRectangle;
import graphics.CartesianSquare;
import graphics.CartesianTriangle;

public class Recitation11 {

	public static void main(String[] args) {
		ShapeStack stack = new ObservableAlignedShapeStack();
		ObjectEditor.edit(stack);
		
		Scanner scanner = new Scanner(System.in);
		for(String input = scanner.next().toLowerCase(); true;
		           input = scanner.next().toLowerCase()) {
			if(input.equals("pop")) {
				stack.pop();
			} else if(input.equals("size")) {
				System.out.println(stack.size());
			} else if(input.equals("t")) {
				stack.push(new CartesianTriangle(scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
			} else if(input.equals("s")) {
				stack.push(new CartesianSquare(scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt()));
			} else if(input.equals("r")) {
				stack.push(new CartesianRectangle(scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt(), scanner.nextInt()));
			} else if(input.equals("o")) {
				stack.push(new CartesianOval(scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt(), scanner.nextInt()));
			} else if(input.equals("c")) {
				stack.push(new CartesianCircle(scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt()));
			} else if(input.equals("l")) {
				stack.push(new CartesianLine(scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt(), scanner.nextInt()));
			} else {
				System.out.println("Unrecognized command");
			}
		}
	}
}