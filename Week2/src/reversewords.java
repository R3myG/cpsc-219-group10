import javax.swing.JOptionPane;


public class reversewords {

	public static void main(String[] args) {
		String fullSentence = JOptionPane.showInputDialog("Enter a sentence without punctuation : ");
		
		String[] sentenceSplited = fullSentence.split(" ");
		int lenght = sentenceSplited.length;
		
		String reverseSentence = "";
		for (int i=lenght-1; i >= 0 ; i--)
			reverseSentence += sentenceSplited[i] + " ";
		
		System.out.printf(reverseSentence);

	}

}
