import java.io.IOException;

public class TestMain {
	 public static void main(String[] args) throws IOException {
	    Album list = new Album("/Users/jijoonghong/eclipse-workspace/Project3/src/Photo-normal.data");
	    list.addPhotoByFileName(";;;;images/JijoongAtJeju.jpg;");
	    list.getPhoto(4).setCategory("Vacation");
	    list.getPhoto(4).setPhotoName("JijoongAtJeju");
	    list.addPhoto(";JijoongAtBusan;;Vacation;images/JijoongAtBusan.jpg;");
	    list.delPhoto(2);
	    for (int i = 0; i < list.numPhotos(); i++) {
	    	list.getPhoto(i).print(); 
	    }
	    list.exportToTxt("/Users/jijoonghong/eclipse-workspace/Project3/src/Photo-Data.txt");
	}
}

