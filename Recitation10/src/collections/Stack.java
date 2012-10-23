package collections;

//Recitation 10:  Change this interface to use Generics.  Only three lines should change.
//                Then implement the interface.

public interface Stack<T> {
	public void push(T item);
	public void pop();
	public int size();
	public T get(int index); //AKA elementAt
	public boolean isEmpty();
	public boolean isFull();
}
