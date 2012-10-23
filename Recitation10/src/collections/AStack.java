package collections;

public class AStack<T> implements Stack<T> {
	static final int DEFAULT_MAX_SIZE = 200;
	Object[] contents = new Object[DEFAULT_MAX_SIZE];
	int size = 0;
	
	@Override
	public void push(T item) {
	contents[size] = item;
	}

	@Override
	public void pop() {
	size--;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) contents[index];
	}

	@Override
	public boolean isEmpty() {
		if (size == 0){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (size == DEFAULT_MAX_SIZE){
			return true;
		}
		else{
		return false;
		}
	}

}
