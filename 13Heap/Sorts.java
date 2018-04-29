import java.util.*;
public class Sorts{
    public static void heapify(int[]data){
	for(int x=data.length-1; x>=0; x--){
	    pushDown(data,x);
	}
    }
    public static void heapsort(int[]data){
	heapify(data);
	int cur = data.length-1;
	for(int x=0; x<data.length; x++){
	    swap(data,0,cur);
	    pushDown2(data,0,cur);
	    cur--;
	}
    }
    public static void pushDown(int[]data,int index){
	int L = index*2+1;	
	int R = index*2+2;
	if(L < data.length && data[index] < data[L] && (R >= data.length || data[R] <= data[L])){
	    swap(data,index,L);
	    pushDown(data,L);	    
	}else if(R < data.length && data[index] < data[R]){
	    swap(data, index, R);
	    pushDown(data,R);			     	    
	}
    }
    public static void pushDown2(int[]data,int index,int limit){
	int L = index*2+1;	
	int R = index*2+2;
	if(L < limit && data[index] < data[L] && (R >= limit || data[R] <= data[L])){
	    swap(data,index,L);
	    pushDown2(data,L,limit);	    
	}else if(R < limit && data[index] < data[R]){
	    swap(data, index, R);
	    pushDown2(data,R,limit);			     	    
	}
    }
    private static void swap(int[]data,int x,int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }
}
