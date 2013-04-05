package com.cpsc219g10.model.AI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Convert {
	private BufferedReader in;
	private String[] lines= new String[100];
	private int[][] moves;
	private int length = 0;
	public static void main(String[] args){
		Convert con = new Convert();
		for(int i=0;i<con.length();i++){
			System.out.println(con.moves(i,0)+" "+con.moves(i,1));
		}
	}
	public int length(){
		return length;
	}
	public int moves(int i, int c){
		return moves[i][c];
	}
	public Convert(){
	    try {
		    in = new BufferedReader(new FileReader("in.txt"));
	        String line;
	        do {
	            line = in.readLine();
	            lines[length]=line;
	        	length++;
	        }while(line != null);
	        length--;
	        in.close();
	    }
	    catch(FileNotFoundException e){
			e.printStackTrace();

	    } catch (IOException e) {
			e.printStackTrace();
		}
	    moves=new int[length][2];
	    for(int i=0;i<length;i++){
	    	moves[i][0]=Integer.parseInt(lines[i].substring(0,1));
	    	moves[i][1]=Integer.parseInt(lines[i].substring(2));

	    }
	}
}
