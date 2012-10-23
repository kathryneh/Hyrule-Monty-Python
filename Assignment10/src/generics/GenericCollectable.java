package generics;

public interface GenericCollectable<T> {
	public Object[] getObjectArray();
	public int size();
	public void pop();
	
	
	//not for token history
	public int getX(); 
	public void setX(int newVal);
	public void setY(int newVal);
	public int getY();
	//public void moveX(int x);
	//public void moveY(int y);
	
	
	public void removeElement();
	public abstract void push(T object); //can we move this to add a type?
	public boolean isFull();
	public T elementAt(int index);
}
