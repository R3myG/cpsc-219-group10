import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

public class drawboard extends JFrame {
	
	public void Fenetre(){
		
		this.setTitle("First window test");
		
		this.setSize(400, 500);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}