package collections;

public class GeneralObjectStack implements TransparentObjectStack {

	private static final int DEFAULT_CAPACITY = 10;
	
	Object[] items;
	int size;
	
	public GeneralObjectStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public GeneralObjectStack(int capacity) {
		if(capacity < 1) {
			System.err.println("Cannot create stack with capacity " + capacity);
			System.err.println("Using default capacity " + DEFAULT_CAPACITY + " instead");
			capacity = DEFAULT_CAPACITY;
		}
		
		items = new Object[capacity];
		size = 0;
	}
	
	public void push(Object obj) {
		if(isFull()) {
			return;
		} else {
			items[size] = obj;
			size++;
		}
	}
	
	public Object peek() {
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
	
	public Object get(int index) {
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