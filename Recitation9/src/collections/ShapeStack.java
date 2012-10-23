package collections;

import graphics.Shape;

/**
 * A transparent stack of Shape objects.
 * DO NOT EDIT THIS INTERFACE IN RECITATION.
 * Feel free to edit this interface if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public interface ShapeStack {
	public void push(Shape shape);
	public Shape peek();
	public void pop();
	public int size();
	public Shape get(int index);
	public boolean isEmpty();
	public boolean isFull();
}