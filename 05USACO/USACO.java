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
	    return countSolutions(pasture,sr,sc,er,ec,t);
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
    private static int countSolutions(char[][] pasture,int sr,int sc,int er,int ec,int t){
	int[] solutions = new int[1];
	solutions[0] = 0;
	countHelp(pasture,sr,sc,er,ec,t,solutions);
	return solutions[0];
    }
    private static void countHelp(char[][] pasture,int sr,int sc,int er,int ec,int t,int[] solutions){
	if(t == 0 && sr == er && sc == ec){
	    solutions[0]++;
	}
	if(t > 0){
	    int[][] coords = new int[][] {
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	    };
	    for(int x=0; x<4; x++){
		int newR = sr + coords[x][0];
		int newC = sc + coords[x][1];
		int distance = Math.abs(er - newR) + Math.abs(ec - newC);
		if(distance < t){
		    if(newR < pasture.length && newR > -1 && newC < pasture[0].length && newC > -1){
			if(pasture[newR][newC] != '*'){
			    countHelp(pasture,newR,newC,er,ec,t-1,solutions);
			}
		    }
		}
	    }
	}
    }
}
	    
    
