package com.cpsc219g10.model.AI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Convert {
	private BufferedReader in;
	private String[] lines= new String[100];
	private int[][] moves;
	private int length = 0;
	static File folder = new File("AIPatterns");
	static File[] listOfFiles = folder.listFiles(); 
	private static Random gen = new Random();

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
	public void rotate(int numberOfRoatations){
		int[][] hold = new int[length][2];
		for(int i=0;i<length;i++){
			hold[i][0]=moves[i][1];
			hold[i][1]=9-moves[i][0];
		}
		moves=hold;
		if(numberOfRoatations!=0){
			rotate(numberOfRoatations-1);
		}
	} 
	public Convert(){
		this(listOfFiles[gen.nextInt(listOfFiles.length)].getName());
	}
	public Convert(String file) {
	    try {
		    in = new BufferedReader(new FileReader("AIPatterns/"+file));
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

	    }	}

	public String toString(){
		String pattern="";
		boolean found = false;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				found = false;
				for(int k=0;k<length;k++){
					if(moves[k][0]==i && moves[k][1]==j){
						pattern+=k+"\t";
						found=true;
						break;
					}
					
				}
				if(!found)
					pattern+="B\t";
			}
			pattern+="\n";
		}
		return pattern;
	}
}
