package collections;

import graphics.Shape;

/**
 * A transparent stack of Shape objects
 * that aligns each newly added shape
 * with the others already in the stack.
 * DO NOT EDIT THIS CLASS IN RECITATION.
 * Feel free to edit this class if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public class AlignedShapeStack implements ShapeStack {

	private static final int DEFAULT_CAPACITY = 10;
	
	private Shape[] items;
	private int size;
	
	public AlignedShapeStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public AlignedShapeStack(int capacity) {
		if(capacity < 1) {
			System.err.println("Cannot create stack with capacity " + capacity);
			System.err.println("Using default capacity " + DEFAULT_CAPACITY + " instead");
			capacity = DEFAULT_CAPACITY;
		}
		
		items = new Shape[capacity];
		size = 0;
	}
	
	public void push(Shape shape) {
		if(isFull()) {
			return;
		}
		
		if(isEmpty()) {
			shape.setX(2);
			shape.setY(2);
		} else {
			Shape topShape = peek();
			shape.setX(topShape.getX() + topShape.getWidth() + 2);
			shape.setY(2);
		}
		
		items[size] = shape;
		size++;
	}
	
	public Shape peek() {
		if(isEmpty()) {
			return null;
		} else {
			return items[size - 1];
		}
	}
	
	public void pop() {
		if(!isEmpty()) {
			size--;
		}
	}
	
	public int size() {
		return size;
	}
	
	public Shape get(int index) {
		if(index >= 0 && index < size()) {
			return items[index];
		} else {
			return null;
		}
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public boolean isFull() {
		return (size() == items.length);
	}
}