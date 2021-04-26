
public class isPalindrome {
	public static boolean isP(String str, int low, int hi) {
		boolean status;
		
		if(str.charAt(low) != str.charAt(hi)) return status = false;
		
		if (low == str.length()/2) return status=true;
		
		low++;
		hi--;
		
		status = isP(str, low, hi);
		
		return status;
		
	}
	
	
	public static void main(String[] args) {
		
		String str = "ABBA";
		boolean status = isP(str, 0, str.length()-1);
		
		System.out.println(status);
		
	}
}
