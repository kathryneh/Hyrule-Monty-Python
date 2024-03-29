package bus.uigen.widgets;

public class ProxyGWTServerEndSelector {
	
	static ProxyGWTServerEndFactory factory;
	
	public static void setProxyGWTServerEndFactory(ProxyGWTServerEndFactory newVal){
		factory = newVal;
	}

	
	public static ProxyGWTServerEnd create(String userDefinedID){
		return factory.create(userDefinedID);
	}
}
