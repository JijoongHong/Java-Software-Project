class GenericStackLimitedCapcity {
	protected int top = -1;
	protected final int INIT_CAPACITY = 2;
	protected Object[] list;
	
	GenericStackLimitedCapcity(){
		list = new Object[INIT_CAPACITY];
	}
	
	GenericStackLimitedCapcity(int capacity){
		list = new Object[capacity];

	}
	
	public boolean isEmpty() {
		return (top<0);
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
		String ss = "GenericStackLimitedCapcity: {";
		for(int i =0; i < top; i++)
			ss += list[i] + ", ";
		ss += list[top];
		ss += "}";
		return ss;
	}
	
}
