package collections;

public interface TransparentObjectStack {
	public void push(Object obj);
	public Object peek();
	public void pop();
	public int size();
	public Object get(int index);
	public boolean isEmpty();
	public boolean isFull();
}