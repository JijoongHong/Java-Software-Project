public class GeneralStackLimitedCapcity {
	private int top = -1;
	private final int INIT_CAPACITY = 2;
	private Object[] list;
	
	GeneralStackLimitedCapcity(){
		list = new Object[INIT_CAPACITY];
	}
	
	GeneralStackLimitedCapcity(int capacity){
		list = new Object[capacity];

	}
	
	public boolean isEmpty() {
		return (top>=0);
	}
	
	public Object pop() {
		if (top >= 0) 
			return list[top--];
		else
			return null;
	}
	
	public void push(Object o) {
		list[++top] = o;
	}
	
	/** Override the toString in the Object class*/
	public String toString() {
		String ss = "";
		for(int i =0; i < top; i++)
			ss += list[i] + " ";
		return ss;
	}
	
}
