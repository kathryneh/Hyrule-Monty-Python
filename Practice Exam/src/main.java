public class main {	
	static int NUM_A_INCREMENTS = 10;
	static int NUM_B_INCREMENTS = 15;
	public static void main(String[] args) {
		Incrementer incrementerA = new AnIncrementer("A");
		Incrementer incrementerB = new AnIncrementer("B");
		incrementerA.register(incrementerB);
		incrementerB.register(incrementerA);
		for (int i = 0; i < NUM_A_INCREMENTS; i++) {
			incrementerA.increment();
		}
		for (int i = 0; i < NUM_B_INCREMENTS; i++) {
			incrementerB.increment();
		}
	
     }
}

