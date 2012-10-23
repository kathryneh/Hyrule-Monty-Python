import java.util.ArrayList;
import java.util.List;
public class AnIncrementer extends ABasicIncrementer implements Incrementer {
	List observers = new ArrayList();
	String name;
	public AnIncrementer(String theName) {
		name = theName;
	}	
	@Override
	public void increment() {
		System.out.println(name + " incremented");
		super.increment();
		notifyObservers();
	}
	void notifyObservers() {
		if (observers == null) {
			System.out.println("observers is null");
			return;			
		}
		System.out.println("Notifying");
		for (int i = 0; i < observers.size(); i++) {
			((Incrementer) observers.get(i)).incremented();
		}
	}	
	public void register(Incrementer incrementer) {
		observers.add(incrementer);
	}
	public void incremented() {
		System.out.println(name + " receivied notification");
		increment();
	}	
}
