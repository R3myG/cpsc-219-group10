package drawwindow;

import java.awt.Graphics;
import javax.swing.JPanel;

public class drawOnWindow extends JPanel {
	private int X_UP = 175;
	private int Y_UP = 75;
	
	private int X_DOWN = 625;
	private int Y_DOWN = 525;
	
	public void paintComponent(Graphics g){

			System.out.println("That's an awesome test ! ! !");
			for (int i=0; i<10 ; i++) {
				g.drawLine(X_UP, Y_UP+i*50, X_DOWN, Y_UP+i*50);
			}
			for (int i=0; i<10 ; i++) {
				g.drawLine(X_UP+i*50, Y_UP, X_UP+i*50, Y_DOWN);
			}
			for (int i=0; i<10 ; i++) {
				g.drawLine(X_UP, Y_UP+i*150, X_DOWN, Y_UP+i*150);
			}
			for (int i=0; i<10 ; i++) {
				g.drawLine(X_UP+i*150, Y_UP, X_UP+i*150, Y_DOWN);
			}
	}
}



/*
 * #UP values
X_UP = 175
Y_UP = 75
#Down values
X_DOWN = 625
Y_DOWN = 525
 *         for i in range(0,10):
                print("line {} {} {} {}".format(X_UP, Y_UP+i*50, X_DOWN, Y_UP+i*50))
        for i in range(0,10):
                print("line {} {} {} {}".format(X_UP+i*50, Y_UP, X_UP+i*50, Y_DOWN))
        print("stroke width 3")
        for i in range(0,4):
                print("line {} {} {} {}".format(X_UP, Y_UP+i*150, X_DOWN, Y_UP+i*150))
        for i in range(0,4):
                print("line {} {} {} {}".format(X_UP+i*150, Y_UP, X_UP+i*150, Y_DOWN))
*/
