import javax.swing.JOptionPane;

public class date {
    public static void main(String[] args) {
	
	String dateAsString = JOptionPane.showInputDialog("Enter the date: ");
	String[] dateSplited = dateAsString.split("/");
	String monthInString = dateSplited[0];
	String dayInString = dateSplited[1];
	String yearInString = dateSplited[2];
	// System.out.printf(day + month + year);
	
	double month = Double.parseDouble(monthInString);
	double day = Double.parseDouble(dayInString);
	double year = Double.parseDouble(yearInString);
	// Check the month 
	if ((1 <= month) && ( month <= 12)) {
	;
	} else System.out.printf("Invalid month"); 
	
	
	
	double[] month31 = new double[7];
	month31[0] = 1;
	month31[1] = 3;
	month31[2] = 5;
	month31[3] = 7;
	month31[4] = 8;
	month31[5] = 10;
	month31[6] = 12;
	
	double[] month30 = new double[4];
	month30[0] = 4;
	month30[1] = 6;
	month30[2] = 9;
	month30[3] = 11;
	
	boolean monthcheck1 = false;
	boolean monthcheck2 = false;
	boolean daycheck = false;
	boolean yearLeapCheck = false;
	boolean leapFev = false;

	if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0))
			yearLeapCheck = true;		
	
	for (int j=0; j<4; ++j)
	if (month30[j] == month)
		monthcheck2 = true;
	
	for (int i=0;i<7; ++i)
	if (month31[i] == month) 
		monthcheck1 = true;
	if ((month == 2) && (yearLeapCheck)) 
		leapFev = true;
		
	if ((1 <= day) && (day <=31) && (monthcheck1)){
				daycheck = true;
				
		//else System.out.printf("\nInvalid day for this month, should be between 1 and 31");
		
	
	}else if ((1 <= day) && (day <= 30) && (monthcheck2)){
			daycheck = true;
		//else System.out.printf("\nInvalid day for this month, should be between 1 and 30");
		
	
    }else if ((month == 2) && (1 <= day) && (day <=29) && (leapFev)){
			daycheck = true;
    }else if ((month == 2) && (1 <= day) && (day <=28) && !(leapFev)){
			daycheck = true;
		//else System.out.printf("\nInvalid day");
    }else System.out.printf("\nInvalid day");
    
    
	if (daycheck){
		System.out.printf("\nDate is correct");
	}else System.out.printf("\nDate isn't correct");
	
    }
	

 
	}
    

