

public class InheritedParaStack<E> extends GenericStackLimitedCapcity{
	
	private E sample;
	
	InheritedParaStack(){
		super();
		list = (E[])list;
	}
	
	InheritedParaStack(int capacity){
		super(capacity);
		list = (E[])list;
	}
	
	public void push(Object o) {
		
		if ((o instanceof E) == false)
			return;
		
		if (top+1 >= list.length) {
			E[] temp = (E[]) new Object[list.length * 2];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
			list[++top] = (E)o;
			//System.out.print(top);
	}
	
	public E pop() {
		if (top >= 0) 
			return (E) list[top--];
		else
			return null;
	}
	
	/** Override the toString in the Object class*/
	public String toString() {
		String ss = "";
		for(int i =0; i < top+1; i++)
			ss += list[i] + " ";
		return ss;
	}
	
	
}
