import java.io.*;
import java.util.*;
public class USACO{
    public static int bronze(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    int r = in.nextInt();
	    int c = in.nextInt();
	    int e = in.nextInt();
	    int n = in.nextInt();
	    int[][] pasture = new int[r][c];
	    for(int x=0; x<r; x++){
		for(int y=0; y<c; y++){
		    pasture[x][y] = in.nextInt();
		}
	    }
	    for(int x=0; x<n; x++){
		int row = in.nextInt();
		int col = in.nextInt();
		int dep = in.nextInt();
		dig(pasture, row-1, col-1, dep);
	    }
	    int sum = 0;
	    for(int x=0; x<r; x++){
		for(int y=0; y<c; y++){
		    if(pasture[x][y] < e){
			sum += e - pasture[x][y];
		    }
		}
	    }
	    return 5184 * sum;
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 1;
    }
    private static void dig(int[][] pasture,int row,int col,int dep){
	int[][] coords = new int[][] {
	    {0,0},
	    {0,1},
	    {0,2},
	    {1,0},
	    {2,0},
	    {1,1},
	    {2,1},
	    {1,2},
	    {2,2}
	};
	while(dep > 0){
	    int max = 0;
	    for(int x=0; x<9; x++){
		if(pasture[row+coords[x][0]][col+coords[x][1]] > max){
		    max = pasture[row+coords[x][0]][col+coords[x][1]];
		}
	    }
	    for(int x=0; x<9; x++){
		if(pasture[row+coords[x][0]][col+coords[x][1]] == max){
		    pasture[row+coords[x][0]][col+coords[x][1]]--;
		}
	    }
	    dep--;
	}
    }
    public static int silver(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    int r = in.nextInt();
	    int c = in.nextInt();
	    int t = in.nextInt();
	    in.nextLine();
	    char[][] pasture = new char[r][c];
	    for(int x=0; x<r; x++){	    
		String line = in.nextLine();
		for(int y=0; y<c; y++){
		    pasture[x][y] = line.charAt(y);
		}
	    }
	    int sr = in.nextInt()-1;
	    int sc = in.nextInt()-1;
	    int er = in.nextInt()-1;
	    int ec = in.nextInt()-1;
	    int[][] oldMoves = new int[r][c];
	    int[][] moves = new int[r][c];
	    oldMoves[sr][sc] = 1;
	    moves[sr][sc] = 1;
	    int[][] coords = new int[][] {
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	    };
	    while(t>0){
		for(int i=0; i<r; i++){
		    for(int j=0; j<c; j++){
			if(oldMoves[i][j] > 0){
			    for(int x=0; x<4; x++){
				int newR = i + coords[x][0];
				int newC = j + coords[x][1];
				if(newR < r && newR > -1 && newC < c && newC > -1 && pasture[newR][newC] != '*'){
				    moves[newR][newC] += oldMoves[i][j];
				}
			    }
			    moves[i][j] = 0;
			}
		    }
		}
		for(int x=0; x<r; x++){
		    oldMoves[x] = moves[x].clone();
		}
		t--;
	    }
	    return moves[er][ec];
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
}
	    
    
