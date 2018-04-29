import java.util.*;
public class MyHeap{
    private Integer[] data;
    private int size;
    private boolean max;
    public MyHeap(){
	data = new Integer[10];
	size = 0;
	max = true;
    }
    public MyHeap(boolean type){
	data = new Integer[10];
	size = 0;
	max = type;
    }
    public String toString(){
	String fin = "";
	for(int x=0; x<size; x++){
	    fin += data[x] + " ";
	}
	return fin;
    }
    public int size(){
	return size;
    }
    public Integer peek(){
	return data[0];
    }
    public void add(Integer element){
	if(size == data.length){
	    resize();
	}
	data[size] = element;
	pushUp(size);
	size++;
    }
    private void pushUp(int index){
	int parent = (index-1)/2;
	if(max && data[index].compareTo(data[parent]) > 0 || !max && data[index].compareTo(data[parent]) < 0){
	    swap(index,parent);
	    pushUp(parent);
	}
    }
    public Integer remove(){
	Integer temp = data[0];
	swap(0,size-1);
	size--;
	pushDown(0);
	return temp;
    }
    private void pushDown(int index){
	int L = index*2+1;
	int R = index*2+2;
	if(L < size() && R < size()){
	    if(max && data[index].compareTo(data[L]) < 0 || !max && data[index].compareTo(data[L]) > 0){	    
		swap(index,L);
		pushDown(L);
	    }else if(max && data[index].compareTo(data[R]) < 0 || !max && data[index].compareTo(data[R]) > 0){	    
		swap(index,R);
		pushDown(R);
	    }
	}
    }
    private void resize(){
	Integer[] fin = new Integer[size * 2];
	for(int x=0; x<data.length; x++){
	    fin[x] = data[x];
	}
	data = fin;
    }
    private void swap(int x, int y){
	Integer temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }
}
