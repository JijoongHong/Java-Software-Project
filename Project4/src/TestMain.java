
public class TestMain {

	public static void main(String[] args) {
		GenericStackLimitedCapcity s0 = new GenericStackLimitedCapcity();
		GenericStackLimitedCapcity s1 = new GenericStackLimitedCapcity();
		GenericStack s2 = new GenericStack();
		GenericStack s3 = new GenericStack();
		ParaStack<String> s4 = new ParaStack<String>();
		ParaStack<Double> s5 = new ParaStack<Double>();
		
		/*
		//(1-1) GenericStackLimitedCapcity 실험 - 오류 
		s1.push(1);
		s1.pop();
		s1.push("Java");
		s1.push(2);
		s0.push(3.141592); //실수 삽입
		s1.push(s0); 
		printStack(s1); // 에러 발생
		*/
		
		
		//(1-2) GenericStackLimitedCapcity 실험 - 정상 
		System.out.println(s1.isEmpty());
		s1 = new GenericStackLimitedCapcity(4);
		s1.push(1); // 정수 삽입 
		s1.pop(); //삭제 
		s1.push("Java"); // 문자열 삽입 
		s1.push(2); // 정수 삽입 
		s0.push(3.141592); //실수 삽입
		s1.push(s0); // 인스턴스 삽입 
		System.out.println(s1.isEmpty());
		printStack(s1); // 정상출력
		
		
		//(2-1) GenericStack 실험 
		System.out.println(s2.isEmpty());
		s2.push(1); //정수 삽입
		s2.pop();
		s2.push("홍지중"); //문자열 삽입 
		s2.push(3); // 정수 삽입 
		s3.push(2.718281); //실수 삽입
		s2.push(s3); // 클래스 삽입 
		System.out.println(s2.isEmpty());
		printStack(s2); // 정상출력
		
		
		/*
		// (3-1) ParaStack 실험 - 오류 
		s4.push(1); //정수 삽입
		s4.pop();
		s4.push("test"); //문자열 삽입 
		s4.push(3); // 정수 삽입 
		s5.push(3.141592); //실수 삽입
		s4.push(s5); // 클래스 삽입 
		printStack(s4); //오류 
		*/
		
		
		// (3-2) ParaStack 실험 - 정상 
		System.out.println(s4.isEmpty());
		s4.push("This"); // 문자열만 삽입 
		s4.push("is");
		s4.push("parastack");
		s4.push("test");
		System.out.println(s4.isEmpty());
		printStack(s4); // 정상출력
		




	}
	
	public static void printStack(Object x) {
		
		System.out.println(x.toString()+'\n');
	}

}
