package collections;

import util.models.VectorListener;

/**
 * An observable transparent stack of Shape objects.
 * DO NOT EDIT THIS INTERFACE IN RECITATION.
 * Feel free to edit this interface if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public interface ObservableShapeStack extends ShapeStack {
	public void addVectorListener(VectorListener listener);
}