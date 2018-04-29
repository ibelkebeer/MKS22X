import java.util.*;
public class MyHeap<T extends Comparable<T>>{
    private T[] data;
    private int size;
    private boolean max;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (T[])new Comparable[10];
	size = 0;
	max = true;
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean type){
	data = (T[])new Comparable[10];
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
    public T peek(){
	return data[0];
    }
    public void add(T element){
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
    public T remove(){
	T temp = data[0];
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
    @SuppressWarnings("unchecked")
    private void resize(){
	T[] fin = (T[])new Comparable[size * 2];
	for(int x=0; x<data.length; x++){
	    fin[x] = data[x];
	}
	data = fin;
    }
    private void swap(int x, int y){
	T temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }
}
