import java.awt.*;
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
	
	public albumFrame() {
		setSize(500, 500);
		jbtDate = new JButton("Date");
		jbtCategory = new JButton("Category");
		jbtEdit = new JButton("EDIT");
		jbtAdd = new JButton("ADD");
		jbtDel = new JButton("DEL...");
		jbtLoad = new JButton("LOAD");
		jbtSave = new JButton("SAVE");
		
		setLayout(new BorderLayout());
		
		JPanel p = new JPanel(new GridLayout(1, 5));
		p.add(jbtEdit);
		p.add(jbtAdd);
		p.add(jbtDel);
		p.add(jbtLoad);
		p.add(jbtSave);
		
		JPanel mode = new JPanel(new BorderLayout());
		mode.add(jbtDate,BorderLayout.WEST);
		mode.add(jbtCategory, BorderLayout.EAST);
		

		JPanel photos = new JPanel(new GridLayout(3, 3, 5, 5));
		
		photos.setBorder(new TitledBorder(new LineBorder(Color.blue),"2020-01-21"));
		
		
		add(mode, BorderLayout.NORTH);
		add(photos, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	

