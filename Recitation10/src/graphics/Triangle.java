package graphics;

/**
 * An interface for an object consisting of three lines that share endpoints.
 * Provides methods for obtaining these lines and the bounding box that
 * contains all three lines.
 * DO NOT EDIT THIS INTERFACE IN RECITATION.
 * Feel free to edit this interface if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public interface Triangle extends Shape {
	public Line getLine1();
	public Line getLine2();
	public Line getLine3();
}