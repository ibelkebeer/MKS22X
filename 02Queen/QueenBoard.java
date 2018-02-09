public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	board = new int[size][size];
	for(int x=0; x<board.length; x++){
	    for(int y=0; y<board[x].length; y++){
	        board[x][y] = 1;
	    }
	}
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
}
