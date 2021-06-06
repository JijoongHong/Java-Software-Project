import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

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


	private PhotoInfo info;
	private PhotoInfo info2;
	private JScrollPane scrollPane;
	private JPanel selected;
	private int mode = 0;
	private Album origData;
	private Album albumData;
	
	AlbumFrame(Album albumData) {
		
		this.albumData = albumData;
		
		try {
			origData = (Album) albumData.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		setSize(680, 600);
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
				
		JPanel btns = new JPanel(new GridLayout(1, 5));
		btns.add(jbtEdit);
		btns.add(jbtAdd);
		btns.add(jbtDel);
		btns.add(jbtLoad);
		btns.add(jbtSave);
		
		
		add(mode, BorderLayout.NORTH);
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.SOUTH);
		add(btns, BorderLayout.SOUTH);
		
		jbtAdd.addActionListener(new Listener());
		jbtLoad.addActionListener(new Listener());
		jbtDate.addActionListener(new Listener());
		jbtCategory.addActionListener(new Listener());
		jbtEdit.addActionListener(new Listener());
		jbtDel.addActionListener(new Listener());
		jbtSave.addActionListener(new Listener());
		
		info = new PhotoInfo();
		info2 = new PhotoInfo();
		info.jbtCancel.addActionListener(new Listener());
		info.jbtOk.addActionListener(new Listener());
		info2.jbtCancel.addActionListener(new Listener());
		info2.jbtOk.addActionListener(new Listener());
		
		showImage();
		}
	
	
	private void showImage() {
		boundaries = new JPanel();
		this.remove(scrollPane);
    	
	    ArrayList<Integer> countEachBase = new ArrayList<Integer>();
	    ArrayList<String> bases = new ArrayList<String>();
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
	    	photo.get(i).addMouseListener(new MouseListener());
	    	String[] tokens = p.getAddTime().split("_");

	    	switch (mode) {
		    	case 0: 
			    	if (bases.contains(tokens[0]))
			    		countEachBase.set(bases.indexOf(tokens[0]), 
			    				countEachBase.get(bases.indexOf(tokens[0]))+1);
			    	else {
			    		bases.add(tokens[0]);
			    		countEachBase.add(1);
			    		count++;
			    	}
			    	break;
			    	
		    	case 1: 
			    	if (bases.contains(p.getCategory()))
			    		countEachBase.set(bases.indexOf(p.getCategory()), 
			    				countEachBase.get(bases.indexOf(p.getCategory()))+1);
			    	else {
			    		bases.add(p.getCategory());
			    		countEachBase.add(1);
			    		count++;
			    	}
			    	break;
	    	}

	    }

		if (count == 1)
			boundaries.setLayout(new GridLayout(2, 1, 5, 5));
		else
			boundaries.setLayout(new GridLayout(count, 1, 5, 5));
	
    	int temp = 0;
    	for (int i = 0; i < count; i++) {
    		int height = countEachBase.get(i) / 3; 
    		if (countEachBase.get(i) % 3 != 0)
    			height++;
    			int remainder = countEachBase.get(i) % 3;

    		photos.add(new JPanel(new GridLayout(height,3, 20, 20)));
    		
    		if (bases.get(i).equals(""))
    			photos.get(i).setBorder(new TitledBorder(new LineBorder(Color.blue),"Unknown"));
    		else
    			photos.get(i).setBorder(new TitledBorder(new LineBorder(Color.blue),bases.get(i)));

    		for (int j = temp; j < countEachBase.get(i)+temp;j++) {
    			photos.get(i).add(photo.get(j));
    		}
    		if (countEachBase.get(i) % 3 != 0) {
	    		for (int j = 0; j < 3 - remainder; j++) {
	    			photos.get(i).add(new JLabel(" "));
	    		}
    		}
    		
    		if (count == 1)
    			photos.add(new JPanel());

    		temp += countEachBase.get(i);
    		boundaries.add(photos.get(i));
    	}

    	scrollPane = new JScrollPane(boundaries);
    	add(scrollPane, BorderLayout.CENTER);
    	this.revalidate();
	}

	
	class Listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == jbtAdd) {
				info.setVisible(true);
	    	}
	    	
	    	if (e.getSource() == jbtLoad) {
	    		
	    		try {
					albumData = (Album) origData.clone();
				}catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
	    	    showImage();
	    	}    
	    
	    	if (e.getSource() == jbtDate) {
	    		mode = 0;
	    		albumData.sortById();
	    		showImage();
	    	}
	    	
	    	if (e.getSource() == jbtCategory) {
	    		mode = 1;
	    		albumData.sortByCategory();
	    		showImage();
	    	}
	    	
	    	if (e.getSource() == jbtEdit) {
	    		
	    		if (selected != null) {
	 		       String path = selected.getComponent(0).toString().split(",")[11].split("=")[1];
			       int index = albumData.getIndex(path);
			       info2.setVisible(true);
			       info2.jtxtName.setText(albumData.getPhoto(index).getPhotoName());
			       info2.jtxtCategory.setText(albumData.getPhoto(index).getCategory());
			       info2.jtxtImageFile.setText(albumData.getPhoto(index).getImageFileName());
	    			
	    		}else 
	    			JOptionPane.showMessageDialog(null, "사진을 선택하세요.");
	    	}
	    	
	    	if (e.getSource() == jbtDel) {
	    		
	    		if (selected != null) {
	 		       String path = selected.getComponent(0).toString().split(",")[11].split("=")[1];
			       int index = albumData.getIndex(path);
			       albumData.delPhoto(index);
			       selected = null;
			       showImage();
	    			
	    		}else 
	    			JOptionPane.showMessageDialog(null, "사진을 선택하세요.");
	    	}
	    	
	    	
	    	if (e.getSource() == jbtSave) {
	    		
	    		albumData.sortById();
	    		
	    		try {
					albumData.export("Photo-normal.data");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		
	    	}
	    	
	    	if (e.getSource() == info.jbtOk) {
	    		DateTimeFormatter formatter = 
						DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS");
	    		
	    		String addedTime = LocalDateTime.now().format(formatter);
	    		albumData.addPhoto("IMG"+addedTime+";"+info.jtxtName.getText()+";"+addedTime+";"+
	    		info.jtxtCategory.getText()+";"+info.jtxtImageFile.getText()+";");
	    		info.dispose();
	    		showImage();
	    	}
	    	
	    	if (e.getSource() == info.jbtCancel) {
	    		info.dispose();
	    	}
	    	
	    	
	    	if (e.getSource() == info2.jbtOk) {
 		        String path = selected.getComponent(0).toString().split(",")[11].split("=")[1];
		        int index = albumData.getIndex(path);
		        albumData.setPhotoName(index, info2.jtxtName.getText());
		        albumData.setCategory(index, info2.jtxtCategory.getText());
		        albumData.setImageFileName(index, info2.jtxtImageFile.getText());
	    		info2.dispose();
	    		selected = null;
	    		showImage();
	    	}
	    	
	    	if (e.getSource() == info2.jbtCancel) {
	    		info2.dispose();
	    	}
	    }
	}
	
	class MouseListener extends MouseAdapter {
		   public void mouseClicked(MouseEvent e) {
		       selected = (JPanel) e.getSource();
		   }
		}
	
}
	



