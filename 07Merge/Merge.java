
import java.util.*;
public class Merge{
    public static void mergesort(int[]data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    public static void msort(int[]data,int[] temp,int lo,int hi){
	if(lo >= hi){
	    return;
	}
	for(int x=lo; x<=hi; x++){
	    temp[x] = data[x];
	}
	int mid = (hi+lo)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,mid+1,hi);
    }
    public static void merge(int[]data,int[]temp,int lo1,int hi1,int lo2,int hi2){
        int cur = lo1;
	while(cur <= hi2){
	    if(lo1 > hi1){
		while(lo2 <= hi2){
		    data[cur] = temp[lo2];
		    cur++;
		    lo2++;
		}
	    }else if(lo2 > hi2){
		while(lo1 <= hi1){
		    data[cur] = temp[lo1];
		    cur++;
		    lo1++;
		}
	    }else if(temp[lo1] <= temp[lo2]){
		data[cur] = temp[lo1];
		cur++;
		lo1++;
	    }else{
		data[cur] = temp[lo2];
		cur++;
		lo2++;
	    }
	}
    }
}
