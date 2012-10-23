package generics;

public class IteratedCollection<T> implements Iterable<T>{
	ObservableCollection<T> observableCollection;
	int nextElementPosition = 0;
	
	public IteratedCollection(ObservableCollection<T> oc){
		observableCollection = oc;
	}
	
	@Override
	public boolean hasNext() {
		if (nextElementPosition < observableCollection.size()){
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		if (hasNext()){
			nextElementPosition++;
			return observableCollection.elementAt(nextElementPosition);
		}
		else{
			return null;
		}		
	}

	@Override
	public void remove() {
		if (nextElementPosition>0){
			nextElementPosition--;
		}
	}

}
