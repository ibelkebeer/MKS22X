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
	int mid = (hi+lo)/2 + 1;
	while(lo < mid){
	    if(data[mid] < data[lo]){
		swap(data,lo,mid);
		if(mid < hi){
		    mid++;
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
}
