package scanner;

public class TokenNumber {
static int tokenNumber = 0;
public TokenNumber(){
	tokenNumber = 0;
}
public static int getTokenNumber(){
	return tokenNumber;
}
public static void accessToken(){
	tokenNumber+=1;
	//tokenNumber = 0;
}
}