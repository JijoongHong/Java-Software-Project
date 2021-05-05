
public class GenericStack extends GenericStackLimitedCapcity{
	
	GenericStack(){
		super();
	}
	
	GenericStack(int capacity){
		super(capacity);
	}
	
	public void push(Object o) {
		
		if (top+1 >= list.length) {
			Object[] temp = new Object[list.length * 2];
			System.arraycopy(list, 0, temp, 0, list.length);
			list = temp;
		}
			list[++top] = o;

	}
	
	
	/** Override the toString in the GenericStackLimitedCapcity class*/
	public String toString() {
		String ss = super.toString();
		ss = ss.replace("GenericStackLimitedCapcity", "GenericStack");
		return ss;
	}
	
}
