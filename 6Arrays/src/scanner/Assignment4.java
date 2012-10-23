package scanner;

public class Assignment4 {
	static String inputString;

	public static void main(String[] input) {
		inputString = input[0];
		scanner.StatefulObject so = new scanner.StatefulObject(input[0]);
		so.setInput(inputString);
		System.out.println(so.getReturnedString());
		// System.out.println("I'm done");
	}
}
