import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PhotoInfo extends JFrame {
	
	JLabel jlbName;
	JLabel jlbAddedTime;
	JLabel jlbShowAddedTime;
	JLabel jlbCategory;
	JLabel jlbCreatedTime;
	JLabel jlbImageFile;
	JLabel jlbSelect;
	
	JButton jbtFile;
	JButton jbtCancel;
	JButton jbtOk;
	
	JTextField jtxtName;
	JTextField jtxtAddedTime;
	JTextField jtxtCategory;
	JTextField jtxtCreatedTime;
	JTextField jtxtImageFile;
	
	public PhotoInfo() {
		setSize(800, 120);
		setLayout(new BorderLayout());
		
		JLabel jlbName = new JLabel("Name");
		JLabel jlbAddedTime = new JLabel("Added Time");
		JLabel jlbShowAddedTime = new JLabel("");
		JLabel jlbCategory = new JLabel("Category");
		JLabel jlbCreatedTime = new JLabel("Created Time");
		JLabel jlbImageFile = new JLabel("Image File");
		JLabel jlbSelect = new JLabel("Select");
		
		JButton jbtFile = new JButton("File");
		JButton jbtCancel = new JButton("Cancel");;
		JButton jbtOk = new JButton("OK");;
		
		JTextField jtxtName = new JTextField();
		JTextField jtxtAddedTime = new JTextField();
		JTextField jtxtCategory = new JTextField();
		JTextField jtxtCreatedTime = new JTextField();
		JTextField jtxtImageFile = new JTextField();
		
		JPanel lbls = new JPanel(new GridLayout(1, 6));
		lbls.add(jlbName);
		lbls.add(jlbAddedTime);
		lbls.add(jlbCategory);
		lbls.add(jlbCreatedTime);
		lbls.add(jlbImageFile);
		lbls.add(jlbSelect);
		
		JPanel txts = new JPanel(new GridLayout(1, 6));
		txts.add(jtxtName);
		txts.add(jlbShowAddedTime);
		txts.add(jtxtCategory);
		txts.add(jtxtCreatedTime);
		txts.add(jtxtImageFile);
		txts.add(jbtFile);
		
		JPanel btns = new JPanel();
		btns.add(jbtCancel);
		btns.add(jbtOk);
		
		add(lbls, BorderLayout.NORTH);
		add(txts, BorderLayout.CENTER);
		add(btns, BorderLayout.SOUTH);
	
		
	}	
	
}
