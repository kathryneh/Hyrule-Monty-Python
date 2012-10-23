package main;

import bus.uigen.ObjectEditor;
import collections.Stack;
import collections.AStack;
import graphics.Triangle;
import graphics.CartesianTriangle;
import graphics.Oval;
import graphics.CartesianOval;

public class Recitation10 {
	public static void main(String[] args) {
		Stack<String> strStack = new AStack<String>(); // set up stack
		strStack.push("Let's");
		strStack.push("Beat");
		strStack.push("State!");
		Stack<Oval> ovalStack = new AStack<Oval>();

		int centerX = 200;
		int centerY = 200;
		
		for(int i=10; i<200; i+=10) //bulls eye
		{
			ovalStack.push(new CartesianOval(centerX-i,centerY-i,2*i,2*i));
		}
		
		int radius = 100;
		for(int i=0; i<360; i+=5)
		{
			
			ovalStack.push(new CartesianOval((int)(centerX+radius*Math.sin(i*3.14/180.0)), 
					(int)(centerY+radius*Math.cos(i*3.14/180.0)), 20, 20));
		}
		int radius2 = 50;
		for(int i=0; i<360; i+=10)
		{
			
			ovalStack.push(new CartesianOval((int)(centerX+radius2*Math.sin(i*3.14/180.0)), 
					(int)(centerY+radius2*Math.cos(i*3.14/180.0)), 30, 30));
		}
		ObjectEditor.edit(strStack); // call Object Editor on stack
		ObjectEditor.edit(ovalStack);
		
		ovalStack.pop();
	}
}
