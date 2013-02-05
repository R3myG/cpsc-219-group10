package drawwindow;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class drawOnWindow extends JPanel {
	private int middleX = 400;
	private int middleY = 300;
	
	
	public void paintComponent(Graphics g){
		int X_UP = middleX -250;
		int Y_UP = middleY -250;
	
		int X_DOWN = middleX + 250;
		int Y_DOWN = middleY + 250;
			System.out.println("That's an awesome test ! ! !");
			for (int i=0; i<11 ; i++) {
				g.drawLine(X_UP, Y_UP+i*50, X_DOWN, Y_UP+i*50);
			}
			for (int i=0; i<11 ; i++) {
				g.drawLine(X_UP+i*50, Y_UP, X_UP+i*50, Y_DOWN);
			}
			
			
	}
}


