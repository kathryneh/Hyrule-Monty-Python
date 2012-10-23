package collections;

import graphics.Shape;

import java.util.ArrayList;

import util.models.VectorChangeEvent;
import util.models.VectorListener;

/**
 * An observable transparent stack of Shape objects
 * that aligns each newly added shape
 * with the others already in the stack.
 * ALL EDITS IN THIS RECITATION SHOULD BE TO THIS CLASS.
 * Feel free to edit this class if you want to
 * use this code in your assignments.
 * 
 * @author Wade Gobel
 */
public class ObservableAlignedShapeStack extends AlignedShapeStack implements ObservableShapeStack {
	ArrayList<VectorListener> al = new ArrayList<VectorListener>();
	public void addVectorListener(VectorListener listener) {
		if (!al.contains(listener)){
			al.add(listener);
		}
	}
	void notifyAllListeners(VectorChangeEvent event){
		for (int i = 0; i<al.size(); i++){
			al.get(i).updateVector(event);
		}
	}
	@Override
	public void push(Shape shape){
		if (!isFull()){
			super.push(shape);
			notifyAllListeners(new VectorChangeEvent(this, 1, al.size()-1, null, shape, al.size()));
		}
	}
	@Override
	public void pop(){
		if (size() > 0){
			super.pop();
			notifyAllListeners(new VectorChangeEvent(this, 2, al.size()-1, null, al.size()));
		}
	}
}