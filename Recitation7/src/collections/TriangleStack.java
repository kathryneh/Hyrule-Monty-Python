package collections;

import collections.GeneralObjectStack;

public class TriangleStack extends GeneralObjectStack {

	public TriangleStack(){
		super();
	}
	
	public TriangleStack(int x){
		super(x);
	}
	
	boolean isTriangleObject(Object obj){
		if(obj instanceof graphics.Triangle){
			return true;
		}
		else if (obj == null){
			return false;
		}
		else {
			return false;
		}
		
	}
	public void push(Object obj){
		if (isTriangleObject(obj)){
			super.push(obj);
		}
		else {
			
		}
	}
}

//push
//pop
//size
//get
//peek