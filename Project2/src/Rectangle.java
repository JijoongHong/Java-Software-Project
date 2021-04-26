public class Rectangle {

	double width;
	double height;
	
	Rectangle(){
		this(1.0, 1.0);
	}
	
	Rectangle(double w, double h){
		this.width = w;
		this.height = h;
	}
	
	void print() {
		System.out.println("width = " + width + ",  height = " + height);		
	}
	
	boolean equal(Rectangle r) {
		   if ((this.width == r.width) && (this.height == r.height))
			  return true;
		   else
			  return false;
		}
	
	double compare(Rectangle r) {
		   return this.width * this.height - r.width * r.height;
		}
	
	
	void resize(double ratio) {
		   this.width *= ratio;
		   this.height *= ratio;
		}

	
}
