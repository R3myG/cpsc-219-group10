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
    private final String HIT = "H";
    private final String MISS ="M";
    private final String FALSE ="F";

    
    public void initialize() {
// declaration section:
// declare a server socket and a client socket for the server
// declare an input and an output stream

// Try to open a server socket on port 9999
// Note that we can't choose a port less than 1023 if we are not
// privileged users (root)
        try {
           echoServer = new ServerSocket(9999);
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
    }

	public void waitForAttack(Player server,Player local) {
		while(!recived){
			try {
				line = is.readLine();
				if(line.indexOf("END")!=-1){
					recived=true;
					if(server.canAttack(local,Integer.parseInt(line.substring(0,1)),line.toCharArray()[2])){
						if(server.attack(local,Integer.parseInt(line.substring(0,1)),line.toCharArray()[2])){
							os.println(HIT);
					}else 
						os.println(MISS);
				}else
					os.println(FALSE);
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
