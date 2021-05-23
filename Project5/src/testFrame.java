import java.awt.*;
import javax.swing.*;

public class testFrame {
	
	public static void main(String[] args) {
		
		
		PhotoInfo frame2 = new PhotoInfo();
		Album albumData = new Album("Photo-normal.data");
		AlbumFrame frame = new AlbumFrame(albumData, frame2);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
