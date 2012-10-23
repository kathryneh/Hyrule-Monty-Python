package main;

public class Main {
	public static void main (String[] args) {
		Employee employee = new AnEmployee("Jane Smith");
		ManagedEmployee managedEmployee = new AManagedEmployee("John Doe", employee);
		System.out.println(employee.getDescription()); 

		System.out.println(managedEmployee.getName()); 

		System.out.println(managedEmployee.getManager().getName());

		System.out.println(managedEmployee.getManager());

		System.out.println(managedEmployee.getDescription());

	}

}
