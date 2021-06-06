import java.awt.*;
import javax.swing.*;

public class testMain {
	
	public static void main(String[] args) {
		
		Album albumData = new Album("Photo-normal.data");
		
		AlbumFrame frame = new AlbumFrame(albumData);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* 동기화 실험용
		AlbumFrame frame2 = new AlbumFrame(albumData);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		
	}
}


