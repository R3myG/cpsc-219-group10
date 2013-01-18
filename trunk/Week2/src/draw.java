
public class draw {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int lower = 1; 
		int higher = 100; 

		int random = (int)(Math.random() * (higher+1-lower)) + lower; 
		
		System.out.println(random);
	}

}
