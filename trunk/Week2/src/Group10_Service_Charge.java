
import javax.swing.JOptionPane;
/*
 Group 10
 Gavin Wiliams
 Remy Gavard
 Nic Swedak
 Terry Wu
 a short class that computes based off of the amount of a deposited check the service charge that will be aplied to the 
 transfer. it inputes and out putes threw the swing class suing JOptionPane's and Calculates the charge based off of what 
 tyre it calles in
 */


public class Group10_Service_Charge {
public static void main(String[] args){
	
	double check_amount, service_charge;
	String out_message;
	
	// ask user for inputed check amount
	check_amount=Double.parseDouble(JOptionPane.showInputDialog("please input the amount of your check"));
	
	//check the amount to see which tyre it falls in moving down from the highest tyre to the lowest
	if (check_amount>1000){
		service_charge=40.0+check_amount*0.01;
	}
	else if(check_amount>100){
		service_charge=5+check_amount*0.05;
	}
	else if(check_amount>10){
		service_charge=check_amount*0.1;
	}
	else{
		service_charge=1;
	}
	
	//generate the output dialog with properly formated amounts. using the format method of the string library
	out_message="for your check of $"+String.format("%.2f", check_amount)+" you will be charged $"+String.format("%.2f", service_charge)+" as a service charge.";
	
	//output the message. using the showmessagedialog
	JOptionPane.showMessageDialog(null,out_message,"Notice",JOptionPane.INFORMATION_MESSAGE);
	
}
}