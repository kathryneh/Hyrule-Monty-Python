package generics;

import java.util.ArrayList;

import util.models.VectorChangeEvent;
import util.models.VectorListener;

public class ObservableCollection<T> extends GenericCollection<T> implements Observable<T> {
	protected ArrayList<VectorListener> listenerArrayList = new ArrayList<VectorListener>();
	
	protected void notifyAllListeners(VectorChangeEvent event){
		for (int i = 0; i<listenerArrayList.size(); i++){
			listenerArrayList.get(i).updateVector(event);
			//System.out.println("Notify All Listeners called" + event);

			//System.out.println("Class of ListChangeEvent Listener" + event.getClass());
		}
	}
	public void addVectorListener(VectorListener listener) {
		if (!listenerArrayList.contains(listener)){
			listenerArrayList.add(listener);
			//System.out.println("Added Vector Listener" + listener);
			//System.out.println("Vector Listener Class" + listener.getClass() );
		}
	}
	@Override
	public void push(T object) {
		if (isFull())
			System.out.println("Adding item to a full history");
		else {
			VectorChangeEvent event = new VectorChangeEvent(this, VectorChangeEvent.AddComponentEvent, listenerArrayList.size(), null, object, listenerArrayList.size() + 1);
			objectArray[size] = object;
			size++;
			notifyAllListeners(event);
			//System.out.println("Adding to size: "+ size);
			//System.out.println("Listener Array Position:" + listenerArrayList.size());
		}
	}
	/*
	@Override
	public void push(T element){
		if (!isFull()){
			super.push(element);
			notifyAllListeners(new VectorChangeEvent(this, 1, al.size()-1, null, element, al.size()));
		}
	}
	@Override
	public void pop(){
		if (size() > 0){
			super.pop();
			notifyAllListeners(new VectorChangeEvent(this, 2, al.size()-1, null, al.size()));
		}
	}*/
}
