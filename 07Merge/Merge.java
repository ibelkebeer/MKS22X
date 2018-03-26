
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
	if(hi-lo <= 19){
	    insertsort(data,lo,hi);
	}else{
	    msort(temp,data,lo,mid);
	    msort(temp,data,mid+1,hi);
	    merge(data,temp,lo,mid,mid+1,hi);
	}
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
    public static void insertsort(int[]data,int lo,int hi){
	for(int x=lo+1; x<=hi; x++){
	    if(data[x] < data[x-1]){
		int index = x-1;
		int cur = data[x];
		while(index > lo && data[x] < data[index]){
		    index--;
		}
		if(data[index] < data[x]){
		    index++;
		}
		for(int i=x; i>index; i--){
		    data[i] = data[i-1];
		}
		data[index] = cur;
	    }
	}
    }
    public static void swap(int[]data,int start,int end){
 	int temp = data[end];
 	for(int x=end; x>start; x--){
 	    data[x] = data[x-1];
 	}
 	data[start] = temp;
    }
}
