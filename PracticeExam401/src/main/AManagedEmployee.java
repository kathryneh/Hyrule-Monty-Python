package main;

public class AManagedEmployee extends AnEmployee implements ManagedEmployee{
	Employee manager;
	public AManagedEmployee(String name, Employee theManager) {
		super (name);
		manager = theManager;		
	}
	public Employee getManager() {
		return manager;
	}
	public String getDescription() {
		return "Managed " + super.getDescription();
	}	
}
