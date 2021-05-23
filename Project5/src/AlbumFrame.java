import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AlbumFrame extends JFrame {
	
	private JButton jbtDate;
	private JButton jbtCategory;
	private JButton jbtEdit;
	private JButton jbtAdd;
	private JButton jbtDel;
	private JButton jbtLoad;
	private JButton jbtSave;
	private JPanel boundaries;
	private Album albumData;
	private PhotoInfo info;
	
	AlbumFrame(Album albumData, PhotoInfo frame) {
		this.albumData = albumData;
		this.info = frame;
		
		setSize(600, 600);
		setLayout(new BorderLayout());
		
		jbtDate = new JButton("Date");
		jbtCategory = new JButton("Category");
		jbtEdit = new JButton("EDIT");
		jbtAdd = new JButton("ADD");
		jbtDel = new JButton("DELETE");
		jbtLoad = new JButton("LOAD");
		jbtSave = new JButton("SAVE");
		
		JPanel mode = new JPanel(new BorderLayout());
		mode.add(jbtDate,BorderLayout.WEST);
		mode.add(jbtCategory, BorderLayout.EAST);
		
		boundaries = new JPanel();
		
		JPanel btns = new JPanel(new GridLayout(1, 5));
		btns.add(jbtEdit);
		btns.add(jbtAdd);
		btns.add(jbtDel);
		btns.add(jbtLoad);
		btns.add(jbtSave);
		
		
		add(mode, BorderLayout.NORTH);
		add(boundaries, BorderLayout.CENTER);
		add(btns, BorderLayout.SOUTH);
		
		jbtAdd.addActionListener(new Listener());
		jbtLoad.addActionListener(new Listener());
		jbtDate.addActionListener(new Listener());
		jbtCategory.addActionListener(new Listener());
		jbtEdit.addActionListener(new Listener());
		jbtDel.addActionListener(new Listener());
		jbtSave.addActionListener(new Listener());

		}
	
	
	private void showImage(Album albumData) {
	    ArrayList<Integer> countEachDate = new ArrayList<Integer>();
	    ArrayList<String> dates = new ArrayList<String>();
	    ArrayList<JPanel> photos = new ArrayList<JPanel>();
	    ArrayList<JPanel> photo = new ArrayList<JPanel>();

	    int count = 0;
	    for (int i = 0; i < albumData.numPhotos(); i++) {
	    	Photo p = albumData.getPhoto(i);
	    	photo.add(new JPanel(new BorderLayout()));
	    	JLabel image = new JLabel(new ImageIcon(p.getImageFileName()));
	    	JLabel name = new JLabel(p.getPhotoName());
	    	name.setHorizontalAlignment(JLabel.CENTER);
	    	photo.get(i).add(image, BorderLayout.NORTH);
	    	photo.get(i).add(name, BorderLayout.SOUTH);
	    	String[] tokens = p.getAddTime().split("_");

	    	
	    	if (dates.contains(tokens[0]))
	    		countEachDate.set(dates.indexOf(tokens[0]), 
	    				countEachDate.get(dates.indexOf(tokens[0]))+1);
	    	else {
	    		dates.add(tokens[0]);
	    		countEachDate.add(1);
	    		count++;
	    	}
	    }
	    
	    boundaries.setLayout(new GridLayout(count, 1, 5, 5));
	
    	int temp = 0;
    	for (int i = 0; i < count; i++) {
    		int height = countEachDate.get(i) / 3; 
    		if (countEachDate.get(i) % 3 != 0)
    			height++;
    			int remainder = countEachDate.get(i) % 3;

    		photos.add(new JPanel(new GridLayout(height,3, 20, 20)));
    		photos.get(i).setBorder(new TitledBorder(new LineBorder(Color.blue),dates.get(i)));

    		for (int j = temp; j < countEachDate.get(i)+temp;j++) {
    			photos.get(i).add(photo.get(j));
    		}
    		if (countEachDate.get(i) % 3 != 0) {
	    		for (int j = 0; j < 3 - remainder; j++) {
	    			photos.get(i).add(new JLabel(" "));
	    		}
    		}

    		temp += countEachDate.get(i);
    		boundaries.add(photos.get(i));
    	}
    	boundaries.revalidate();
	}
		
	
	
	
	class Listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == jbtAdd) {
				info.setVisible(true);
	    	}
	    	
	    	if (e.getSource() == jbtLoad) {
	    	    showImage(albumData);
	    	}    
	    
	    	if (e.getSource() == jbtDate) {
	    		albumData.sortById();
	    		showImage(albumData);
	    	}
	    	
	    	if (e.getSource() == jbtCategory) {
	    		albumData.sortByCategory();
	    		showImage(albumData);
	    	}
	    	if (e.getSource() == jbtEdit) {
	    		
	    		//albumData.set___()
	    		showImage(albumData);
	    		
	    	}
	    	
	    	if (e.getSource() == jbtDel) {
	    		//albumData.delPhoto();
	    		showImage(albumData);
	    	}
	    	
	    	
	    	if (e.getSource() == jbtSave) {
	    		try {
					albumData.exportToTxt("output.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    }
	}
}
	



