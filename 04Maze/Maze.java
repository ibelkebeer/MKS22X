import java.util.*;
import java.io.*;
public class Maze{
    private char[][] maze;
    private int[][] coords;
    private boolean animate;
    public Maze(String filename) throws FileNotFoundException{
	ArrayList<String> rows = new ArrayList<String>();
	File f = new File(filename);
	Scanner in = new Scanner(f);
	while(in.hasNext()){
	    String line = in.nextLine();
	    rows.add(line);
	}
	maze = new char[rows.size()][rows.get(0).length()];
	int numS = 0;
	int numE = 0;
	for(int x=0; x<rows.size(); x++){
	    for(int y=0; y<rows.get(0).length(); y++){
		maze[x][y] = rows.get(x).charAt(y);
		if(rows.get(x).charAt(y) == 'S'){
		    numS++;
		}
		if(rows.get(x).charAt(y) == 'E'){
		    numE++;
		}
	    }
	}
	if(numS != 1 || numE != 1){   
	    throw new IllegalStateException("Error: Invalid number of start or end points");
	}
	coords = new int[][] {
	    {1,0},
	    {0,1},
	    {-1,0},
	    {0,-1}
	};
    }
    public String toString(){
	String fin = "";
	for(int x=0; x<maze.length; x++){
	    for(int y=0; y<maze[0].length; y++){
		fin += maze[x][y];
	    }
	    fin += "\n";
	}
	return fin;
    }
    public void setAnimate(boolean b){
	animate = b;
    }
    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }
    public int solve(){
	int row = 0;
	int col = 0;
	for(int x=1; x<maze.length - 1; x++){
	    for(int y=1; y<maze[0].length - 1; y++){
		if(maze[x][y] == 'S'){
		    row = x;
		    col = y;
		}
	    }
	}
	return solve(row,col);
    }
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    private int solve(int row, int col){
	int ats = 0;
        solveHelp(row,col);
	for(int x=1; x<maze.length-1; x++){
	    for(int y=1; y<maze[0].length-1; y++){
		if(maze[x][y] == '@'){
		    ats++;
		}
	    }
	}
	if(ats > 0){
	    return ats;
	}else{
	    return -1;
	}
    }
    private boolean solveHelp(int row, int col){
	maze[row][col] = '@';
	if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
	for(int x=0; x<4; x++){
	    if(maze[row + coords[x][0]][col + coords[x][1]] == 'E'){
		return true;
	    }
	    if(maze[row + coords[x][0]][col + coords[x][1]] == ' '){
		if(solveHelp(row + coords[x][0],col + coords[x][1])){
		    return true;
		}
		maze[row + coords[x][0]][col + coords[x][1]] = '.';
	    }
	}
	return false;
    }
}
