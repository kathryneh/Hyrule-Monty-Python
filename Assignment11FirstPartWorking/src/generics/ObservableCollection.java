package generics;

import java.util.ArrayList;

import util.models.VectorChangeEvent;
import util.models.VectorListener;

public class ObservableCollection<T> extends GenericCollection<T> implements Observable<T> {
	public ArrayList<VectorListener> al = new ArrayList<VectorListener>();

	public void addVectorListener(VectorListener listener) {
		if (!al.contains(listener)){
			al.add(listener);
		}
	}
	public void notifyAllListeners(VectorChangeEvent event){
		for (int i = 0; i<al.size(); i++){
			al.get(i).updateVector(event);
			System.out.println("Notify All Listeners called");
		}
	}
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
	}
}
