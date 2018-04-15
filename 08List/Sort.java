import java.util.*;
public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer>data){
	if(data.size() > 1){
	    int max = data.get(data.max());
	    int min = data.get(data.min()) * -1;
	    if(min > max){
		max = min;
	    }
	    int digits = (int)Math.log10(max)+1;
	    data = radixsortHelp(data,digits,1);
	}
    }
    private static MyLinkedListImproved<Integer> radixsortHelp(MyLinkedListImproved<Integer>data,int digit,int cur){
	if(cur > digit){
	    return data;
	}
	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] ary = new MyLinkedListImproved[20];
	for(int i=0; i<20; i++){
	    ary[i] = new MyLinkedListImproved<>();
	}
	for(Integer i : data){
	    int tempdig;
	    int tempnum;
	    boolean negative = false;
	    if(i < 0){
		tempnum = i * -1;
		negative = true;
	    }else{
		tempnum = i;
	    }
	    if(cur == 1){
		tempdig = tempnum % 10;
	    }else{
		if((int)Math.log10(tempnum)+1 < cur){
		    tempdig = 0;
		}else{
		    tempdig = tempnum / (int)Math.pow(10,cur-1) % 10;
		}
	    }
	    if(negative){
		ary[9 - tempdig].add(i);
	    }else{
		ary[10 + tempdig].add(i);
	    }
	}
	data.clear();
	for(int i=0; i<20; i++){
	    if(ary[i].size() > 0){
		data.extend(ary[i]);
	    }
	}
	return radixsortHelp(data,digit,cur+1);
    }
}

