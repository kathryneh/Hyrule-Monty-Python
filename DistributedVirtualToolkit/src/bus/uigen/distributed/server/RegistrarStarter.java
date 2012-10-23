package bus.uigen.distributed.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RegistrarStarter extends Thread{
	public static String PORT = "15151";

	
	public void run(){
		try {
			LocateRegistry.createRegistry(Integer.parseInt(PORT));
			RmiServerEnd registrar = new AnRmiServerEnd();
			Naming.rebind(getFullRegistrarName(), registrar);
			System.err.println("Registrar started at "+getFullRegistrarName());
			while(true){
				Thread.sleep(600000);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void start(){
		super.start();
	}
	
	public static String getFullRegistrarName(){
		return "//"+getHostName()+":"+PORT+"/"+RmiServerEnd.REGISTRAR_NAME;
	}
	
	public static String getHostName(){
		/*String toReturn = "";
		try {
			toReturn = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return toReturn;*/
		
		//return "192.168.100.4";
		return "152.2.142.146";
	}
	
	public static RmiServerEnd getRegistrar(){
		try {
			return (RmiServerEnd) Naming.lookup(getFullRegistrarName());
		} catch (Exception  e) {
			return null;
		}
	}
}
