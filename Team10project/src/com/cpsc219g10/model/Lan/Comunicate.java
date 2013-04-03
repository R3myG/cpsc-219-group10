package com.cpsc219g10.model.Lan;
	import java.io.*;
	import java.net.*;
public class Comunicate {
    private Socket smtpSocket = null;  
    private DataOutputStream os = null;
    private DataInputStream is = null;
    public void initiate(String host) {
	/* declaration section:
	 * smtpClient: our client socket
	 * os: output stream
	 * is: input stream
	 * Initialization section:
	 * Try to open a socket on port 9999
	 */
	        try {
	            smtpSocket = new Socket(host, 9999);
	            os = new DataOutputStream(smtpSocket.getOutputStream());
	            is = new DataInputStream(smtpSocket.getInputStream());
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host: hostname");
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to: hostname");
	        }
	// If everything has been initialized then we want to write some data
	// to the socket we have opened a connection to on port 25
	    }
	public boolean send_message(String message){
	    if (smtpSocket != null && os != null && is != null) {
	            try {
			        os.writeBytes(message);    
			        os.writeBytes("END");
			        return true;
	            } catch (UnknownHostException e) {
	                System.err.println("Trying to connect to unknown host: " + e);
	                return false;
	            } catch (IOException e) {
	                System.err.println("IOException:  " + e);
	                return false;
	            }    
	// keep on reading from/to the socket till we receive the "Ok" from SMTP,
	// once we received that then we want to break.
	    }
		return false;
	}
	public String recive_message(){
        String responseLine = null;
		try{
	        while ((responseLine = is.readLine()) != null) {
	            System.out.println("Server: " + responseLine);
	            if (responseLine.indexOf("Ok") != -1) {
	              break;
	            }
	        }
		}catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
        return responseLine;
	}
	public void disconect(){
		try{
	    os.close();
	    is.close();
	    smtpSocket.close();  
		}catch (UnknownHostException e) {
	        System.err.println("Trying to connect to unknown host: " + e);
	    } catch (IOException e) {
	        System.err.println("IOException:  " + e);
	    }
		
		}
}

