import java.util.*;
public class KnightBoard{
    private int[][] board;
    private int[][] coords;
    private int[][] moves;
    public KnightBoard(int rows, int cols){
	if(rows < 0 || cols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[rows][cols];
	moves = new int[rows][cols];
	coords = new int[][] {
	    {1,2},
	    {1,-2},
	    {-1,2},
	    {-1,-2},
	    {2,1},
	    {2,-1},
	    {-2,1},
	    {-2,-1}
	};
    }
    public String toString(){
	String fin = "";
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] < 10){
		    fin += " " + board[x][y] + " ";
		}else{
		    fin += board[x][y] + " ";
		}
	    }
	    fin += "\n";
	}
	return fin;
    }
    private boolean moveH(int row, int col, int step, int coord){
	int newRow = row + coords[coord][0];
	int newCol = col + coords[coord][1];
        if(newRow < board.length && newRow >= 0 && newCol < board[newRow].length && newCol >= 0 && board[newRow][newCol] == 0){
	    board[newRow][newCol] = step;
	    return true;
	}
	return false;
    }
    public boolean solve(int row, int col){
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if(row < 0 || col < 0 || row > board.length || col > board[row].length){
	    throw new IllegalArgumentException();
	}
	for(int x=0; x<moves.length; x++){
	    for(int y=0; y<moves[x].length; y++){
		for(int z=0; z<8; z++){
		    if(moveH(x,y,1,z)){
			moves[x][y] ++;
			board[x + coords[z][0]][y + coords[z][1]] = 0;
		    }
		}
	    }
	}
	board[row][col] = 1;
	if(solveHelp(row, col, 2)){
	    return true;
	}
	board[row][col] = 0;
	return false;
    }
    public boolean solveHelp(int row, int col, int step){
	boolean done = true;
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] == 0){
		    done = false;
		}
	    }
	}
	if(done){
	    return true;
	}
	int[] spots = new int[8];
	int move = 0;
	for(int x=0; x<8; x++){
	    if(moveH(row,col,step,x)){
	        spots[x] = moves[row + coords[x][0]][col + coords[x][1]];
		board[row + coords[x][0]][col + coords[x][1]] = 0;
		move+= 1;
	    }
	} 
	while(move > 0){
	    int min = -1;
	    for(int x=0; x<8; x++){
		if(min == -1 && spots[x] != 0){
		    min = x;
		}
		if(spots[x] != 0 && spots[x] < spots[min]){
		    min = x;
		}
	    }
	    spots[min] = 0;
	    if(moveH(row,col,step,min)){
		if(solveHelp(row + coords[min][0],col + coords[min][1],step+1)){
		    return true;
		}
		board[row + coords[min][0]][col + coords[min][1]] = 0;
	    }
	    move -= 1;
	}
	return false;
    }
    public int countSolutions(int row, int col){
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if(row < 0 || col < 0 || row > board.length || col > board[row].length){
	    throw new IllegalArgumentException();
	}
	board[row][col] = 1;
	int temp = solutionsHelp(row, col, 0);
	board[row][col] = 0;
	return temp;
    }
    private int solutionsHelp(int row, int col, int solutions){
	boolean done = true;
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] == 0){
		    done = false;
		}
	    }
	}
	if(done){
	    return 1;
	}
	for(int x=0; x < 8; x++){
	    if(moveH(row,col,1,x)){
		solutions += solutionsHelp(row + coords[x][0],col + coords[x][1], 0);
		board[row + coords[x][0]][col + coords[x][1]] = 0;
	    }
	}
	return solutions;
    }
}
