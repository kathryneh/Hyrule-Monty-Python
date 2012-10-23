package bus.uigen.distributed.nongwt;

import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.ProxyGWTServerEndFactory;

public class NonGWTProxyGWTServerEndFactory implements ProxyGWTServerEndFactory {

	public ProxyGWTServerEnd create(String userDefinedID) {
	
		return new NonGwtProxyGWTServerEnd(userDefinedID);
	}

}
