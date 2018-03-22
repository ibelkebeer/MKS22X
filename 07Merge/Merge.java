import java.util.*;
public class Merge{
    public static void mergesort(int[]data){
	msort(data,0,data.length-1);
    }
    public static void msort(int[]data,int lo,int hi){
	if(hi-lo < 1){
	    return;
	}
	msort(data,lo,(hi+lo)/2);
	msort(data,(hi+lo)/2+1,hi);
	merge(data,lo,hi);
    }
    public static void merge(int[]data,int lo,int hi){
	//System.out.println(Arrays.toString(data)+","+lo+","+hi);
	int mid = (hi+lo)/2 + 1;
	int cur = mid;
	while(lo < mid){
	    if(data[cur] < data[lo]){
		swap(data,lo,cur);
		if(mid < hi){
		    mid++;
		    cur++;
		}
		
	    }
	    lo++;
        }
    }
    public static void swap(int[]data,int start,int end){
	int temp = data[end];
	for(int x=end; x>start; x--){
	    data[x] = data[x-1];
	}
	data[start] = temp;
    }
    public static void main(String[]args){
        /*int[] test = new int[] {3,9,1,4,1,5,7,9,3,12,11,3,6,8,2};
	mergesort(test);
	*/
	
	int[] test = new int[1000];
	for(int x=0; x<1000; x++){
	    test[x] = (int)(Math.random() * 1000);
	}
	mergesort(test);
	boolean sorted = true;
	for(int x=0; x<999; x++){
	    if(test[x] > test[x+1]){
		sorted = false;
	    }
	}
	
	System.out.println(sorted);
    }
}
