package collections;

public interface StackSwapper {
	public TransparentObjectStack getStackA();
	public TransparentObjectStack getStackB();
	public void swapAToB();
	public void swapBToA();
}