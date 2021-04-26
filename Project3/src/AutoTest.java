
public class AutoTest {
	 public static void main(String[] args) {
		 
		System.out.println("Case1: Normal Input  ");
	    Album list = new Album("/Users/jijoonghong/eclipse-workspace/Project3/src/Photo-normal.data");
	    int i;
	    for (i = 0; i < list.numPhotos(); i++) {
	    	list.getPhoto(i).print(); 
	    	
	    }
	    	
	    System.out.println("End of Case1");
	    System.out.println("");
	    
	    
	    System.out.println("Case2: Check String Trimming  ");
	    System.out.println("The result should be the same as the normal case above. ");
	    list = new Album("/Users/jijoonghong/eclipse-workspace/Project3/src/trimming-test.data");
	    for (i = 0; i < list.numPhotos(); i++)
	    	list.getPhoto(i).print(); 
	    System.out.println("");
	    System.out.println("End of Case2");
	    System.out.println("");
	    System.out.println("");
	    System.out.println("*** From now on, Test Reactions on Abnormal Inputs ***");
	    System.out.println("Your Answer (your program's reaction) should be similar to the Correct Answer");
	    System.out.println("");
	    System.out.println("Case3-1: No Image File ");
	    System.out.println("  Correct Answer: No Image File  ; Skip the input line : IMG2021-01-02_15:49:33:152;Rose2;2021-01-02_15:49:33:152;; ; ");
	    System.out.print("   Your  Answer : ");
	    list = new Album("/Users/jijoonghong/eclipse-workspace/Project3/src/notitle.data");
	    for (i = 0; i < list.numPhotos(); i++)
	    	list.getPhoto(i).print(); 
	    System.out.println("End of Case3-1");
	    System.out.println("");
	    
	    
	    System.out.println("Case3-2: Check Date Format Error  ->");
	    System.out.println("  Correct Answer: Wrong Date Format ; Skip the input line : IMG2021-01-02_15:49:33:153;Lily;2021-01-02  15:49:33:153; flower;images/lily.jpg; ");
	    System.out.print("   Your  Answer : ");
	    list = new Album("/Users/jijoonghong/eclipse-workspace/Project3/src/wrong-dateformat.data");
	    for (i = 0; i < list.numPhotos(); i++)
	      list.getPhoto(i).print(); 
	    System.out.println("End of Case3-2");
	    System.out.println("");
	    
	    
	    
	    System.out.println("Case3-3: ID Conflict Error  -> ");
	    System.out.println("  Correct Answer: ID Conflict (a photo with the same ID already exists); Skip the input line: IMG2021-01-02_15:49:33:152;Lily;2021-01-02_15:49:33:152;flower;images/lily.jpg;");
	    System.out.print("   Your  Answer : ");
	    list = new Album("/Users/jijoonghong/eclipse-workspace/Project3/src/ID-conflict.data");
	    for (i = 0; i < list.numPhotos(); i++)
	      list.getPhoto(i).print(); 
	    System.out.println("End of Case3-3");
	    System.out.println("");
	    
	    
	    System.out.println("Case4: Unknwon Album Information File ");
	    System.out.println("  Correct Answer: Unknwon Album data File ");
	    System.out.print("   Your  Answer : ");
	    list = new Album("/Users/jijoonghong/eclipse-workspace/Project3/src/unknown-file.data");
	    for (i = 0; i < list.numPhotos(); i++)
	      list.getPhoto(i).print(); 
	    System.out.println("End of Case4");
	    System.out.println("");
	 }
}
