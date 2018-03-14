import java.util.*;
public class Quick{
    public static int partition(int[] data, int start, int end){
	int pivotIndex = (int)(Math.random() * (end - start + 1) + start);
	int pivot = data[pivotIndex];
	int first = start;
	data[pivotIndex] = data[start];
	data[start] = pivot;
	start++;
	while(start <= end){
	    if(data[start] < pivot){
		start++;
	    }
	    else if(data[start] > pivot){
		int temp = data[end];
		data[end] = data[start];
		data[start] = temp;
		end--;
	    }
	}
	data[first] = data[end];
	data[end] = pivot;
	return end;
    }
    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length - 1;
	int v = partition(data,start,end);
	while(v != k){
	    if(v < k){
		start = v+1;
	    }else{
		end = v;
	    }
	    v = partition(data,start,end);
	}
	return data[v];
    }
    public static void main(String[]args){
	int[] test = {2,10,15,23,0,5};
	System.out.println(quickselect(test,5));
    }
}
