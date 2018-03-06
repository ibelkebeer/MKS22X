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
	    int[] solutions = new int[1];
	    solutions[0] = 0;
	    countPaths(pasture,in.nextInt()-1,in.nextInt()-1,in.nextInt()-1,in.nextInt()-1,t,solutions);
	    return solutions[0];
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
    private static boolean countPaths(char[][] pasture,int sr,int sc,int er,int ec,int t,int[] solutions){
	int[][] coords = new int[][] {
	    {1,0},
	    {0,1},
	    {-1,0},
	    {0,-1}
	};
	if(t == 0 && sr == er && sc == ec){
	    return true;
	}
	for(int x=0; x<4; x++){
	    if(sr+coords[x][0] < pasture.length && sr+coords[x][0] > -1 && sc+coords[x][1] < pasture[0].length && sc+coords[x][1] > -1 && t != 0 && pasture[sr+coords[x][0]][sc+coords[x][1]] != '*'){
		if(countPaths(pasture,sr+coords[x][0],sc+coords[x][1],er,ec,t-1,solutions)){
		    solutions[0]++;
		}
	    }
	}
	return false;
    }
}
	    
    
