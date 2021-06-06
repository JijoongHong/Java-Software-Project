import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Album implements Cloneable {
	
	private ArrayList<Photo> Album;
	private int numOfPhotos;
	
	Album(String photoInfoFileName){
		this.Album = new ArrayList<Photo>();
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
			Album.add(this.numOfPhotos++, new Photo(id, photoName, addTime, category, imageFileName));
		}
	}
	
	
	public int numPhotos() {
		return this.numOfPhotos;
	}
	
	public Photo getPhoto(int i) {
		return Album.get(i);
	}
	
	public void setCategory(int i, String category) { //*
		Album.get(i).setCategory(category);
	}
	
	public void setPhotoName(int i, String photoName) { //*
		Album.get(i).setPhotoName(photoName);
	}
	
	public void setImageFileName(int i, String ImageFileName) { //*
		Album.get(i).setImageFileName(ImageFileName);
	}

	private boolean fileNameValidator(String imageFileName) {
		if(imageFileName.equals("")) {
			return false;
		}else return true;
	}
	
	private boolean idConflictValidator(String id) {
		for(int i = 0; i<this.numOfPhotos; i++) {
			if(Album.get(i).getId().equals(id)) return true;
		}
		return false;
	}
	
	
	public void addPhotoByFileName(String line) {
		String[] tokens = line.split(";");
		String fileName = tokens[tokens.length-1];
		Album.add(this.numOfPhotos++, new Photo(fileName));
	}
	
	
	public void addPhoto(String line) {
		String[] tokens = line.split(";");
		String fileName = tokens[tokens.length-1];
		String photoName = tokens[1].replaceAll(" ", "");
		String category = tokens[3].replaceAll(" ", "");
		Album.add(this.numOfPhotos++, new Photo(fileName, photoName, category));
	}
	
	public void delPhoto(int i) {
		numOfPhotos--;
		Album.remove(i);
	}
	
	public void export(String path) throws IOException{
		FileWriter fileWriter = new FileWriter(path);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		for(int i = 0; i < numOfPhotos; i++) {
			
			printWriter.print(Album.get(i).getId()+";"+Album.get(i).getPhotoName()+";"+Album.get(i).getAddTime()
					+";"+Album.get(i).getCategory()+";"+Album.get(i).getImageFileName()+";\n");
		}
		printWriter.close();
	}
	
	
	public int getIndex(String path) {
		int index = 0;
		for (int i=0; i<numOfPhotos; i++) {
			if (Album.get(i).getImageFileName().equals(path)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void sortById() {
		Comparator<Photo> idComparator = new Comparator<Photo>() {
            @Override
            public int compare(Photo o1, Photo o2) {
                return o1.getAddTime().compareTo(o2.getAddTime());
            }
        };
        Collections.sort(Album,idComparator);
    }

	public void sortByCategory() {
		Comparator<Photo> categoryComparator = new Comparator<Photo>() {
            @Override
            public int compare(Photo o1, Photo o2) {
                return o1.getCategory().compareTo(o2.getCategory());
            }
        };
        Collections.sort(Album,categoryComparator);
	}
     
	public Object clone() throws CloneNotSupportedException {
		 Album a = (Album)super.clone();
		 a.Album = (ArrayList) this.Album.clone();
		 return a;
	}

	
}
