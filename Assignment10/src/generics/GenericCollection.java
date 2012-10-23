package generics;

public abstract class GenericCollection<T> implements GenericCollectable<T> {
	protected final static int ARRAY_MAX_SIZE = 50;
	protected Object[] objectArray = new Object[ARRAY_MAX_SIZE];
	protected int size = 0;
	protected int x;
	protected int y;
	
	@Override
	public Object[] getObjectArray() {
		return objectArray;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void pop() {
		if (size > 0) {
			size--;
		} else {
			System.out.println("Collection is empty. No elements to remove.");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void removeElement() {
		size = size();
		for (int i = 0; i < size; i++) {
			 objectArray[i] = (T) objectArray[i + 1];
		}
		size--;
	}

	@Override
	public void push(T object) {
		if (isFull())
			System.out.println("Adding item to a full history");
		else {
			objectArray[size] = object;
			size++;
			System.out.println("Adding to size: "+ size);
		}
	}

	@Override
	public boolean isFull() {
		return size == ARRAY_MAX_SIZE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T elementAt(int index) {
		return (T) objectArray[index];
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int newVal) {
	x = newVal;
	}

	@Override
	public void setY(int newVal) {
	y = newVal;
	}

	@Override
	public int getY() {
		return y;
	}

}
