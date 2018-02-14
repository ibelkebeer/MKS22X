public class KnightBoard{
    private int[][] board;
    private int[][] coords;
    public KnightBoard(int rows, int cols){
	if(rows < 0 || cols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[rows][cols];
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
	board[row][col] = 1;
	System.out.println(this);
	if(solveHelp(row, col, 2)){
	    return true;
	}
	board[row][col] = 0;
	return false;
    }
    private boolean solveHelp(int row, int col, int step){
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
	for(int x=0; x<8; x++){
	    if(moveH(row,col,step,x)){
		
		if(solveHelp(row + coords[x][0],col + coords[x][1],step+1)){
		    return true;
		}
		board[row + coords[x][0]][col + coords[x][1]] = 0;
	    }
	}
	return false;
    }
}
