public abstract class ABasicIncrementer {
   int counter = 0;
   public ABasicIncrementer() {
	increment();
   }
   public void increment() {
	counter++;			System.out.println(counter);	
   }	
   abstract void notifyObservers();
}
