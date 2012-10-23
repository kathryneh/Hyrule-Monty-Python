package bus.uigen.distributed.gwt;

import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.ProxyGWTServerEndFactory;

public class GWTProxyGWTServerEndFactory implements ProxyGWTServerEndFactory {

	public ProxyGWTServerEnd create(String userDefinedID) {
		return new GWTProxyGWTServerEnd(userDefinedID);
	}

}
