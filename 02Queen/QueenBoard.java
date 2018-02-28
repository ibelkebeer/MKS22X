public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	if(size < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[size][size];
    }
    private boolean addQueen(int r, int c){
	if(board[r][c] == 0){
	    board[r][c] = -1;
	    for(int i = r-1, j = c+1; i >= 0 && j < board.length; i--, j++){
		board[i][j] ++;
	    }
	    for(int i = r+1, j = c+1; i < board.length && j < board.length; i++, j++){
		board[i][j] ++;
	    }
	    for(int i = c+1; i < board.length; i++){
		board[r][i] ++;
	    }
	    return true;
	}
	return false;
    }
    private boolean removeQueen(int r, int c){
	if(board[r][c] == -1){
	    board[r][c] = 0;
	    for(int i = r-1, j = c+1; i >= 0 && j < board.length; i--, j++){
		board[i][j] --;
	    }
	    for(int i = r+1, j = c+1; i < board.length && j < board.length; i++, j++){
		board[i][j] --;
	    }
	    for(int i = c+1; i < board.length; i++){
		board[r][i] --;
	    }
	    return true;
	}
	return false;
    }
    public String toString(){
	String fin = "";
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] > -1){
		    fin += "_ ";
		}else{
		    fin += "Q ";
		}
	    }
	    fin += "\n";
	}
	return fin;
    }
    public boolean solve(){
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelp(0);
    }
    private boolean solveHelp(int queens){
	if(queens >= board.length){
	    return true;
	}
	for(int x=0; x < board.length; x++){
	    if(addQueen(x, queens)){
		if(solveHelp(queens + 1)){
		    return true;
		}
		removeQueen(x, queens);
	    }
	}
	return false;
    }
    public int countSolutions(){
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solutionsHelp(0, 0);
    }
    private int solutionsHelp(int queens, int solutions){
	if(queens >= board.length){
	    return 1;
	}
	for(int x=0; x < board.length; x++){
	    if(addQueen(x, queens)){
		solutions += solutionsHelp(queens+1, 0);
	    }
	    removeQueen(x, queens);
	}
	return solutions;
    }
}

