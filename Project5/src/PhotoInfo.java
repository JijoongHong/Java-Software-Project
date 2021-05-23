import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PhotoInfo extends JFrame {
	
	private JLabel jlbName;
	private JLabel jlbAddedTime;
	private JLabel jlbShowAddedTime;
	private JLabel jlbCategory;
	private JLabel jlbCreatedTime;
	private JLabel jlbImageFile;
	private JLabel jlbSelect;
	
	private JButton jbtFile;
	private JButton jbtCancel;
	private JButton jbtOk;
	
	private JTextField jtxtName;
	private JTextField jtxtCategory;
	private JTextField jtxtCreatedTime;
	private JTextField jtxtImageFile;
	
	PhotoInfo() {
		setSize(800, 120);
		setLayout(new BorderLayout());
		
		jlbName = new JLabel("Name");
		jlbAddedTime = new JLabel("Added Time");
		jlbShowAddedTime = new JLabel("");
		jlbCategory = new JLabel("Category");
		jlbCreatedTime = new JLabel("Created Time");
		jlbImageFile = new JLabel("Image File");
		jlbSelect = new JLabel("Select");
		
		jbtFile = new JButton("File");
		jbtCancel = new JButton("Cancel");;
		jbtOk = new JButton("OK");;
		
		jtxtName = new JTextField();
		jtxtCategory = new JTextField();
		jtxtCreatedTime = new JTextField();
		jtxtImageFile = new JTextField();
		
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
		
		jbtFile.addActionListener(new Listener());
		jbtCancel.addActionListener(new Listener());
		jbtOk.addActionListener(new Listener());
		
	}	
	
	class Listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == jbtFile) {
	    	}
	    	
	    	if (e.getSource() == jbtCancel) {

	    	}    
	    
	    	if (e.getSource() == jbtOk) {

	    	}

	    }
	}
	
}
