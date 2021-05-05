
public class ParaStack<E>{
	
	private int top = -1;
	private final int INIT_CAPACITY = 2;
	private Object[] list;
	
	ParaStack(){
		list = (E[]) new Object[INIT_CAPACITY];
	}
	
	ParaStack(int capacity){
		list = (E[]) new Object[capacity];
	}
	
	public void push(E o) {
		
		if (top+1 >= list.length) {
			E[] temp = (E[]) new Object[list.length * 2];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
			list[++top] = o;
	}
	
	public boolean isEmpty() {
		return (top<0);
	}
	
	public E pop() {
		if (top >= 0) 
			return (E) list[top--];
		else
			return null;
	}
	
	public String toString() {
		String ss = "ParaStack: {";
		for(int i =0; i < top; i++)
			ss += list[i] + ", ";
		ss += list[top];
		ss += "}";
		return ss;
	}
	
}





