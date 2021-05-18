import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class albumFrame extends JFrame {
	
	JLabel jlbClicked;
	JButton jbtDate;
	JButton jbtCategory;
	JButton jbtEdit;
	JButton jbtAdd;
	JButton jbtDel;
	JButton jbtLoad;
	JButton jbtSave;
	JPanel boundaries;
	
	albumFrame() {
		setSize(500, 500);
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

		}
	
	

	
	class Listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == jbtAdd) {
		    	PhotoInfo frame2 = new PhotoInfo();
				frame2.setVisible(true);
	    	}
	    	
	    	if (e.getSource() == jbtLoad) {
	    	    Album albumData = new Album("Photo-normal.data");
	    	    int count = 0;
	    	    ArrayList<Integer> countEachDate = new ArrayList<Integer>();
	    	    ArrayList<String> dates = new ArrayList<String>();
	    	    ArrayList<JPanel> photos = new ArrayList<JPanel>();
	    	    ArrayList<JLabel> photo = new ArrayList<JLabel>();
	    	    
	    	    for (int i = 0; i < albumData.Album.size(); i++) {
	    	    	Photo p = albumData.Album.get(i);
	    	    	String[] tokens = p.getAddTime().split("_");
	    	    	photo.add(new JLabel(new ImageIcon(p.getImageFileName())));
	    	    	
	    	    	if (dates.contains(tokens[0]))
	    	    		countEachDate.set(dates.indexOf(tokens[0]), dates.indexOf(tokens[0])+1);
	    	    	else {
	    	    		dates.add(tokens[0]);
	    	    		countEachDate.add(1);
	    	    		count++;
	    	    	}
	    	    }
	    	  int temp = 0;
	    	  for (int i = 0; i < count; i++) {
	    		  int height = countEachDate.get(i) / 3; 
	    		  if (countEachDate.get(i) % 3 != 0)
	    			  height++;
	    				  
	    		  photos.add(new JPanel(new GridLayout(height, 3, 5, 5)));
	    		  photos.get(i).setBorder(new TitledBorder(new LineBorder(Color.blue),dates.get(i)));
	    		  
	    		  for (int j = temp; j < countEachDate.get(i)+temp;i++) {
	    			  photos.get(i).add(photo.get(j));
	    		  }
	    		  temp += countEachDate.get(i)+1;
	    		  boundaries.add(photos.get(i));
	    	  }
	    	    
	    	    boundaries.repaint();
	    	    
	    	}
	    }
	}

		
		

		
	
	
	
	}
	



