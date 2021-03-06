import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Album {
	
	private Photo[] Album;
	private int numOfPhotos;
	
	
	
	Album(String photoInfoFileName){
		this.Album = new Photo[100];
		this.numOfPhotos = 0;
		this.getData(photoInfoFileName);
	}
	
	private void getData(String photoInfoFileName) {
		try {
			File file = new File(photoInfoFileName);
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				String line = input.nextLine();

				if(line.startsWith("//") || line.isEmpty()) {
					continue;
				}else {
					getPhotoInfo(line);
				}
			}
			input.close();
		}
		catch(Exception e) {
			//e.printStackTrace(); 
			System.out.println("Unknown Album data File");
		} 
	}
		
	private void getPhotoInfo(String line) {
		String[] tokens = line.split(";");
		String id = tokens[0].replaceAll(" ", "");
		String photoName = tokens[1].replaceAll(" ", "");
		boolean isCorrectDateFormat;
		LocalDateTime addTime = null;
		try {
			DateTimeFormatter formatter = 
					DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS");
			addTime = LocalDateTime.parse(tokens[2].replaceAll(" ", ""), formatter);
			isCorrectDateFormat = true;
		}catch (DateTimeParseException e) {
			isCorrectDateFormat = false;
			System.out.println("Wrong Date Format : Skip the input line : "+line);
			
		}
		String category = tokens[3].replaceAll(" ", "");
		String imageFileName = tokens[4].replaceAll(" ", "");
		
		boolean isFileNameExist = fileNameValidator(imageFileName);
		boolean isConflict = idConflictValidator(id);
		if (isFileNameExist == false && isCorrectDateFormat == true) {
			System.out.println("No Image File : Skip the input line : "+line);
		};
		if (isConflict == true && isFileNameExist == true) {
			System.out.println("ID Conflict (a photo with the same ID already exist) : Skip the input line : "+line);
		};
		if (isCorrectDateFormat == true && isFileNameExist == true && isConflict == false) {
			Album[this.numOfPhotos++] = new Photo(id, photoName, addTime, category, imageFileName);
		}
	}
	
	
	
	public int numPhotos() {
		return this.numOfPhotos;
	}
	
	public Photo getPhoto(int i) {
		if (i == 0)
			System.out.println("The album has "+this.numOfPhotos+" photos");
		
		return Album[i];
	}
	
	//-----------?????? ?????? ??????-----------//
	
	private boolean fileNameValidator(String imageFileName) {
		if(imageFileName.equals("")) {
			return false;
		}else return true;
		 
	}
	
	private boolean idConflictValidator(String id) {
		for(int i = 0; i<this.numOfPhotos; i++) {
			if(Album[i].getId().equals(id)) return true;
		}
		return false;
	}
	
	public void addPhotoByFileName(String line) {
		String[] tokens = line.split(";");
		String fileName = tokens[tokens.length-1];
		Album[this.numOfPhotos++] = new Photo(fileName);
	}
	
	
	public void addPhoto(String line) {
		String[] tokens = line.split(";");
		String fileName = tokens[tokens.length-1];
		String photoName = tokens[1].replaceAll(" ", "");
		String category = tokens[3].replaceAll(" ", "");
		Album[this.numOfPhotos++] = new Photo(fileName, photoName, category);
	}
	
	public void delPhoto(int i) {
		Photo[] temp = new Photo[100];
		int j=0,flag=0;
		
		while (j < numOfPhotos) {
			if (i == j) {
				j++;
				flag=1;
			}
			else if(flag==1){
				temp[j-1] = Album[j];
				j++;
				
			}else {
				temp[j] = Album[j];
				j++;
			}
		}
		numOfPhotos--;
		Album = temp;
	}
	
	public void exportToTxt(String path) throws IOException{
		FileWriter fileWriter = new FileWriter(path);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		for(int i = 0; i < numOfPhotos; i++) {
			
			printWriter.print(Album[i].getId()+";"+Album[i].getPhotoName()+";"+Album[i].getAddTime()
					+";"+Album[i].getCategory()+";"+Album[i].getImageFileName()+";\n");
		}
		printWriter.close();
	}
	
	
	public void sortById() {
		//ArrayList??? Compartor ?????? ?????? ???????????? 
	}
	
	public void sortByCategory() {
		//ArrayList??? Compartor ?????? ?????? ???????????? 
	}
	
	public void sortByPhotoName() {
		//ArrayList??? Compartor ?????? ?????? ???????????? 
	}
	
}
