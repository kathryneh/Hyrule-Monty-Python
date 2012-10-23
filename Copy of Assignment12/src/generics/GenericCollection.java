package generics;

import java.util.ArrayList;

import util.models.VectorChangeEvent;
import util.models.VectorListener;

public abstract class GenericCollection<T> implements GenericCollectable<T> {
	protected final static int ARRAY_MAX_SIZE = 50;
	protected Object[] objectArray = new Object[ARRAY_MAX_SIZE];
	protected int size = 0;
	protected int x;
	protected int y;
	protected ArrayList<VectorListener> listenerArrayList = new ArrayList<VectorListener>();

	
	
	public Object[] getObjectArray() {
		return objectArray;
	}

	public void addVectorListener(VectorListener listener) {
		if (!listenerArrayList.contains(listener)){
			listenerArrayList.add(listener);
			System.out.println("Added Vector Listener" + listener);
		}
	}
	
	protected void notifyAllListeners(VectorChangeEvent event){
		System.out.println("Class of ListChangeEvent" + event.getClass());
		for (int i = 0; i<listenerArrayList.size(); i++){
			listenerArrayList.get(i).updateVector(event);
			System.out.println("Class of ListChangeEvent");
			System.out.println("Notify All Listeners called" + event);
		}
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
			//VectorChangeEvent event = new VectorChangeEvent(this, VectorChangeEvent.AddComponentEvent, listenerArrayList.size(), null, object, listenerArrayList.size() + 1);
			objectArray[size] = object;
			size++;
			//notifyAllListeners(event);
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
