
public class BoardTest {
	public static void main(String[] args){
		Boat b1= new Boat(0,"Gavin");
		Boat b2= new Boat(1,"Gavin");
		Boat b3= new Boat(2,"Gavin");
		Boat b4= new Boat(3,"Gavin");
		Boat b5= new Boat(4,"Gavin");
		
		Board gb = new Board("Gavin");
		
		b1.setPosition(1,1,true);
		b2.setPosition(2,2,true);
		b3.setPosition(3,3,true);
		b4.setPosition(4,4,true);
		b5.setPosition(5,5,true);
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);

		gb.addBoat(b1);
		gb.addBoat(b2);
		gb.addBoat(b3);
		gb.addBoat(b4);
		gb.addBoat(b5);
		System.out.print(gb);
		for(int i=0;i<10;i+=1){
			for(char j='a';j<'k';j+=1){
				System.out.println("attack: "+i+","+j+"\t"+
						gb.targetSquare(i,j));
			}
			System.out.println(gb);
		}

		
		
	}
}
