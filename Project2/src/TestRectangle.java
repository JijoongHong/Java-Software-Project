public class TestRectangle {
	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(1.0, 2.0);
		Rectangle r3 = new Rectangle(2.0, 1.0);
		
		
		if (r2.equal(r3))
			System.out.println("two rectangles are equal. \n");
		else
			System.out.println("two rectangles are different. \n");
		
		
		if (r2.compare(r3) > 0)
			System.out.println("the first is larger than the second. \n");
		else if (r2.compare(r3) < 0)
			System.out.println("the first is smaller than the second. \n");
		else
			System.out.println("two are the same in area. \n");
		
		
		r1.print();
		r1.resize(2.0);
		r1.print();
		
		System.out.println("20176963 홍지중");
		
	}
}

