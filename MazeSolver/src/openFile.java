import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class openFile {	
	JFileChooser file_chooser = new JFileChooser();
	public static int row ;
	public static int column;
	public static int startPosX;
	public static int startPosY;
	public static int endPosX;
	public static int endPosY;

	public static ArrayList<String> values = new ArrayList<String>();
	//File Selecter class used to look for the textfile that has tbe maze.
	public void pick_me() throws IOException{
		//if statement use to check if a file is grabbed.
		if(file_chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File file = file_chooser.getSelectedFile();
			Scanner input = new Scanner(file);
			//BufferedReader bufferReader = new BufferedReader(new FileReader(file));
			//reads the first 3 lines of the file to grab the maze size, starting and ending points.
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String text = null;
				while ((text = br.readLine()) != null) {
					values.add(text);
				}
				
				//splitting the attributes and declaring them as integers
				//placed in public variables for other classes to access
				//row and column used for mazeArray size deceleration as well as loop conditions.
				//startPosX & startPosY used to declare the starting position of the map.
				//endPosX & endPosY used to declare the ending position of the map.
				String[] mazeSize = values.get(0).split(" ");
				row = Integer.parseInt(mazeSize[0]);
				column = Integer.parseInt(mazeSize[1]);
				String[] start = values.get(1).split(" ");
				startPosX = Integer.parseInt(start[0]);
				startPosY = Integer.parseInt(start[1]);
				String[] end = values.get(2).split(" ");
				endPosX = Integer.parseInt(end[0]);
				endPosY = Integer.parseInt(end[1]);

			} 
			catch (IOException exp) {
				exp.printStackTrace();
			}
			input.close(); 
		}else {
			JOptionPane.showMessageDialog(null, "A file was not selected.");
		}


	}		
}
