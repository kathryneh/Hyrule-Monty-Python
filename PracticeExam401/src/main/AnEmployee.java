package main;

public class AnEmployee implements Employee{
	String name;
	public AnEmployee(String theName) {
		name = theName.toLowerCase();
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return "Employee:" + name;
	}
	public String toString() {
		return getDescription();
	}
}
