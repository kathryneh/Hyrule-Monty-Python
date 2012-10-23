import java.util.Scanner;


public class PairOfTwins {
public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
		while(true){
			float nextFloat = scanner.nextFloat();
			float Tearth = nextFloat;
			float Trel = scanner.nextFloat();
			if (Trel == 0 && Tearth == 0) break;
			System.out.println((findVelocity(Tearth, Trel)));
		}
	
}
public static String findVelocity(float Tearth, float Trel){
	float gamma = (Trel/Tearth);
	float velocity = (float) Math.sqrt((1-(gamma*gamma)));
	float velocityDecimals = (float) (velocity*1000);
	velocityDecimals = Math.round(velocityDecimals);	
	String stringVelocity = "0."+Integer.toString((int)velocityDecimals);
	return stringVelocity;
	
}


}
