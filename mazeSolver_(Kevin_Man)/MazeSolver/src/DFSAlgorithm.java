import java.awt.List;
import java.util.ArrayList;


public class DFSAlgorithm {

	public static boolean searchPath(String[][] mazeArray, int x, int y, ArrayList<Integer> path) {
		//start of recursive algorithm.
		//using depth first searching.
		
		//end search if reaching exit ("E").
		if (mazeArray[y][x] == "E") {
			path.add(x);
			path.add(y);
			return true;
		}
		
		//recursive search through all paths that have not been visited.
		// "0" = none visited path.
		// "X" = visited path.
		//dx and dy used to determine direction to take.
		if (mazeArray[y][x] == "0") {
			mazeArray[y][x] = "X";
			int dx = -1;
			int dy = 0;
			
			//of path is correct, add current coordinates to path
			if (searchPath(mazeArray, x + dx, y + dy, path)) {
				path.add(x);
				path.add(y);
				return true;
			}

			dx = 1;
			dy = 0;
			if (searchPath(mazeArray, x + dx, y + dy, path)) {
				path.add(x);
				path.add(y);
				return true;
			}

			dx = 0;
			dy = -1;
			if (searchPath(mazeArray, x + dx, y + dy, path)) {
				path.add(x);
				path.add(y);
				return true;
			}

			dx = 0;
			dy = 1;
			if (searchPath(mazeArray, x + dx, y + dy, path)) {
				path.add(x);
				path.add(y);
				return true;
			}
		}
		return false;    
	}
}