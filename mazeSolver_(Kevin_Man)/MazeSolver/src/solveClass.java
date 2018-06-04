import java.awt.List;
import java.util.ArrayList;

public class solveClass {
	public static String[][] mazeArray= new String [openFile.row][openFile.column];
	public static ArrayList<Integer> path = new ArrayList<Integer>();
	public static String[][] solve() {
		int count = 3;

		//mazeArray array storing the whole maze.
		//mazeSection stores a row of the maze, used to split values into multiple array elements.
		//I.E: value = (1 1 1 1), mazeSections = 1, 1, 1, 1 
		String mazeArray[][] = new String[openFile.row][openFile.column];
		String[] mazeSections = openFile.values.get(count).split(" ");
		//loops through the the total amount held within values and splits them all within mazeSections.
		for (int i = 0; i < openFile.column; ++i){
			mazeSections = openFile.values.get(count).split(" ");
			count++;
			// transfers mazeSection list into a 2d array called mazeArray
			// also turns strings to the right presentational string.
			for (int k = 0; k < openFile.row; ++k){
				if( mazeSections[k].contains("1")){
					mazeArray[k][i] = "#";
				}
				else if (mazeSections[k].contains("0")){
					mazeArray[k][i] = "0";
				}
			}
		}
		//Inputs the exit "E" into the maze for computing.
		mazeArray[openFile.endPosX][openFile.endPosY] = "E";
		
		//declares the depth first search with variables.
		DFSAlgorithm.searchPath(mazeArray, openFile.startPosX, openFile.startPosY, path);
		
		//for loop for inputting the resulting path found from DFSAgorithm into the maze
		for (int p = 0; p < path.size(); p += 2) {
			int pathX = path.get(p);
			int pathY = path.get(p + 1);
			mazeArray[pathY][pathX] = "X";
		}
		
		//reapplies the Exit onto the maze due to the above loop.
		//applies the Start symbol to the maze.
		mazeArray[openFile.endPosX][openFile.endPosY] = "E";
		mazeArray[openFile.startPosX][openFile.startPosY] = "S";

		//turns any left over "0" into " " for presentation.
		for(int r = 0; r<openFile.column; r++)
		{
			for(int j = 0; j<openFile.row; j++)
			{
				if (mazeArray[j][r] == "0"){
					mazeArray[j][r] = " ";
				}
			}
		}

		//nested for loop to print compiled maze to the console.
		for(int r = 0; r<openFile.column; r++)
		{
			for(int j = 0; j<openFile.row; j++)
			{
				System.out.print(mazeArray[j][r]);
			}
			System.out.println();
		}
		return mazeArray;
	}	
}
