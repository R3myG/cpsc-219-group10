package com.cpsc219g10.model.Lan;
import java.io.*;
import java.net.*;

import com.cpsc219g10.model.Player;
public class server {
    private ServerSocket echoServer = null;
    private String line;
    private DataInputStream is;
    private PrintStream os;
    private Socket clientSocket = null;
    private boolean recived = false;
    private final String HIT = "Hit";
    private final String MISS ="Miss";
    private final String FALSE ="False";
    public static void main(String[] args){
    	server com = new server();
    	com.initialize();
    	Player p1,p2;
    	p1=new Player("server");
    	p2=new Player("local");
    	com.waitForAttack(p1,p2);
    }
    
    public void initialize() {
        System.out.println("Server initilizing");

// declaration section:
// declare a server socket and a client socket for the server
// declare an input and an output stream

// Try to open a server socket on port 9999
// Note that we can't choose a port less than 1023 if we are not
// privileged users (root)
        try {
           echoServer = new ServerSocket(9998);
        }
        catch (IOException e) {
           System.out.println(e);
        }   
// Create a socket object from the ServerSocket to listen and accept 
// connections.
// Open input and output streams
    try {
           clientSocket = echoServer.accept();
           is = new DataInputStream(clientSocket.getInputStream());
           os = new PrintStream(clientSocket.getOutputStream());
// As long as we receive data, echo that data back to the client.
        }   
    catch (IOException e) {
           System.out.println(e);
        }
    System.out.println("Server initilized");
    }

	@SuppressWarnings("deprecation")
	public void waitForAttack(Player server,Player local) {
		recived=false;
	    System.out.println("Server waiting for attack");
		while(!recived){
			try {
				System.out.println("try");
				line = is.readLine();
				if(line.indexOf("END")!=-1){
					recived=true;
					System.out.println("try");
					System.out.println(line);
					if(server.canAttack(local,Integer.parseInt(line.substring(0,1)),line.toCharArray()[1])){
						if(server.attack(local,Integer.parseInt(line.substring(0,1)),line.toCharArray()[1])){
							os.println(HIT);
						}else 
							os.println(MISS);
					}else
						os.println(FALSE);
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
