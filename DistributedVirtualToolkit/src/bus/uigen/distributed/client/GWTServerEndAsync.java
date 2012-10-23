package bus.uigen.distributed.client;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GWTServerEndAsync {

	void send(String command, AsyncCallback<Void> callback);

	void setID(String userDefinedID, AsyncCallback<Void> callback);

	void getCommands(AsyncCallback<ArrayList<String>> callback);

	void getID(AsyncCallback<String> callback);

	void getUniqueID(AsyncCallback<String> callback);

	void sendListener(VirtualListener listener, String id,
			AsyncCallback<Void> callback);

	void getListeners(AsyncCallback<Map<String, VirtualListener>> callback);

}
