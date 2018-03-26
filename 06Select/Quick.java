import java.util.*;
public class Quick{
    private static void swap(int[] data,int x,int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }
    private static void partition(int[] data, int start, int end){
	if(end-start < 10){
	    insertionsort(data,start,end);
	}else{
	    int pivotIndex = (int)(Math.random() * (end - start + 1) + start);
	    int pivot = data[pivotIndex];
	    swap(data,pivotIndex,start);
	    int lt = start;
	    int i = start+1;
	    int gt = end;
	    while(i <= gt){
		if(data[i] == pivot){
		    i++;
		}
		else if(data[i] > pivot){
		    swap(data,i,gt);
		    gt--;
		}
		else{
		    swap(data,i,lt);
		    lt++;
		    i++;
		}
	    }
	    if(start < end-1){
		if(i < data.length){
		    partition(data,i,end);	    
		}
		partition(data,start,lt-1);
	    }
	}
    }
    private static void insertionsort(int[]data,int lo,int hi){
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
    private static int[] partition2(int[] data, int start, int end){
	int pivotIndex = (int)(Math.random() * (end - start) + start);
	int pivot = data[pivotIndex];
        swap(data,pivotIndex,start);
	int lt = start;
	int i = start+1;
	int gt = end;
	while(i <= gt){
	    if(data[i] == pivot){
		i++;
	    }
	    else if(data[i] > pivot){
		swap(data,i,gt);
		gt--;
	    }
	    else{
		swap(data,i,lt);
		lt++;
		i++;
	    }
	}
        int[] range = {lt,gt};
	return range;
    }
    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length - 1;
	int[] v = partition2(data,start,end);
	while(v[0] > k || v[1] < k){
	    if(v[1] < k){
		start = v[1]+1;
	    }else{
		end = v[0]-1;
	    }
	    v = partition2(data,start,end);
	}
	return data[v[0]];
    }
    public static void quicksort(int[] data){
	partition(data,0,data.length-1);
    }
}
