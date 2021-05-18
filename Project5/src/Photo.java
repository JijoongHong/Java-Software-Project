import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Photo {

	private String id;
	private String photoName;
	private String addTime;
	private String category;
	private String imageFileName;
	
	
	Photo(String imageFileName){
		this.imageFileName = imageFileName;
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS");
		this.addTime = now.format(formatter).toString();
		this.id = "IMG"+this.addTime;
	}
	
	
	Photo(String imageFileName, String photoName, String category){
		this.imageFileName = imageFileName;
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS");
		this.addTime = now.format(formatter).toString();
		this.id = "IMG"+this.addTime;
		this.category = category;
		this.photoName = photoName;
	}
	
	Photo(String id, String photoName, LocalDateTime addTime, String category, String imageFileName){
		this.id = id;
		this.photoName = photoName;
		LocalDateTime time = addTime;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS");
		this.addTime = time.format(formatter).toString();
		this.category = category;
		this.imageFileName = imageFileName;
	}
	
	
	public void print() {
		System.out.print(this.id+";"+this.photoName+";"+this.addTime+";"+
						this.category+";"+this.imageFileName+";\n");
	}
	
	//-----------추가 구현 사항-----------//
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPhotoName() {
		return this.photoName;
	}
	
	public String getAddTime() {
		return this.addTime;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String getImageFileName() {
		return this.imageFileName;
	}
	
}

