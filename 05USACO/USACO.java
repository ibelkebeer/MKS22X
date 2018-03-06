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
		stomp(pasture, row-1, col-1, dep);
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
    private static void stomp(int[][] pasture,int row,int col,int dep){
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
}
	    
    
