package drawwindow;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;


public class drawboard extends JFrame {
	
	public drawboard(){
		
		this.setTitle("First window test");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		
		this.setContentPane(new drawOnWindow());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		drawboard draw1 = new drawboard();
		
	}
}