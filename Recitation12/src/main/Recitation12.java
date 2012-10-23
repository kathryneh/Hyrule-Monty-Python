package main;

import graphics.Triangle;
import graphics.CartesianTriangle;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;


public class Recitation12 {
	public static void main(String[] args) {
		Triangle t = new CartesianTriangle(100,100,150,100,100,150);
		OEFrame frame = ObjectEditor.edit(t);
		frame.hideMainPanel();
		frame.setSize(500,500);
	}
}
