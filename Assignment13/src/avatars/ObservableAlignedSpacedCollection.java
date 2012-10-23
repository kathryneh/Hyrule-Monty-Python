package avatars;

import generics.Observable;

public abstract class ObservableAlignedSpacedCollection extends AlignedSpacedCollection implements Observable<Talkable> {

	public ObservableAlignedSpacedCollection(int xloc, int yloc) {
		super(xloc, yloc);
	}

	@Override
	public void push(Talkable avatar){
		if (!isFull()){
			super.push(avatar);
		}
	}
	@Override
	public void removeElement(){
		if (size() > 0){
			super.removeElement();
		}
	}
}
