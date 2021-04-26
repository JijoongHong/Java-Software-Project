
public class ExecTime {

	public static void main(String[] args) {
		long startTime, endTime, execTime;
		int N = 1000000;
		
		startTime = System.nanoTime();
		
		for (int i=0; i<N; i++) {
			d2x(65535);
		}
		
	
		
		
		int n = 125080;
		System.out.println("Demical " + n + " is converted to " + d2x(n));
		
		endTime = System.nanoTime();
		execTime = endTime - startTime;
		//System.out.println("Execution Time in nano seconds = " + (double)(execTime/N));
		System.out.println("20176963 홍지중");
	}
	
	
	
	public static String d2x(int n) {
		
		String result = "";
		String result2 = "";
		String numbers = "0123456789ABCDEF";
		
		do {
			result = result + numbers.charAt(n % 16) + ' ';
			n /= 16;
			
        } while (n != 0);
		
		for (int i = result.length()-2; i>=0; i--) {
			result2 = result2 + result.charAt(i);
		}

		return result2;
	}
}

/*
public class ExecTime {

	public static void main(String[] args) {
		long startTime, endTime, execTime;
		int N = 1000000;
		
		startTime = System.nanoTime();
		 
		for (int i=0; i<N; i++) {
			d2x(65535);
		}
		
		int n =16;
		System.out.println("Demical " + n + " is converted to " + d2x(n));
		
		endTime = System.nanoTime();
		execTime = endTime - startTime;
		System.out.println("Execution Time in nano seconds = " + (double)(execTime/N));
		System.out.println("20176963 홍지중");
	}
	
	
	
	public static String d2x(int n) {
		
		int remainder;
		String result = "";
		String result2 = "";
		
		
		while (true) {
			
			remainder = n % 16;
			
			if (remainder == 15){
				result = result + 'f';
			} else if (remainder == 14) {
				result = result + 'e';
			}
			else if (remainder == 13) {
				result = result + 'd';
			}
			else if (remainder == 12) {
				result = result + 'c';
			}
			else if (remainder == 11) {
				result = result + 'b';
			}
			else if (remainder == 10) {
				result = result + 'a';
			}
			else {
				result = result + remainder;
			}
			
			
			if (n / 16 == 0) {
				break;
				
			} else{
				result = result + ' ';
			}
			
			n = n / 16;
		}
		
		for (int i = result.length()-1; i>=0; i--) {
			result2 = result2 + result.charAt(i);
		}
		
		
		return result2;
	}
}
*/
//System.nanoTime();
//int n = 2048;
//System.out.println("Demical " + n + " is converted to " + d2x(n));