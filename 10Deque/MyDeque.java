import java.util.*;
public class MyDeque<E>{
    private E[]ary;
    private int start;
    private int end;
    private int size;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	ary = (E[])new Object[10];
	start = 9;
	end = 0;
	size = 0;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	ary = (E[])new Object[initialCapacity];
	start = initialCapacity - 1;
	end = 0;
	size = 0;
    }
    public int size(){
	return size;
    }
    public String toString(){
	String fin = "[";
	int temp = start+1;
	for(int i=0; i<size-1; i++){
	    fin += ary[temp % ary.length] + ",";
	    temp++;
	}
	if(end == 0 && size > 0){
	    fin += ary[temp % ary.length];
	}else if(size > 0){
	    fin += ary[end-1];
	}
	return fin + "]";
    }
    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(ary[start] == null){
	    ary[start] = element;
	    start--;
	    if(start < 0){
		start += ary.length;
	    }
	    size++;
	}else{
	    start++;
	    resize();
	    ary[start] = element;
	    start--;
	    size++;
	}
    }
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(ary[end] == null){
	    ary[end] = element;
	    end++;
	    end = end % ary.length;
	    size++;
	}else{
	    start++;
	    resize();
	    ary[end] = element;
	    end++;
	    size++;
	}
    }
    @SuppressWarnings("unchecked")
    public void resize(){
	E[] bigger = (E[])new Object[size + 10];
	int temp = 10;
	for(int i=0; i<size; i++){
	    bigger[temp] = ary[start % size];
	    start++;
	    temp++;
	}
	ary = bigger;
	end = 0;
	start = 9;
    }
    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	E temp;
	if(start == ary.length-1){
	    temp = ary[0];
	    ary[0] = null;
	    start = 0;
	    size--;
	}else{
	    start++;
	    temp = ary[start];
	    ary[start] = null;
	    size--;
	}
	return temp;
    }
    public E removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	E temp;
	if(end == 0){
	    temp = ary[ary.length - 1];
	    ary[ary.length - 1] = null;
	    end = ary.length - 1;
	    size--;
	}else{
	    end--;
	    temp = ary[end];
	    ary[end] = null;
	    size--;
	}
	return temp;
    }
    public E getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(start == ary.length - 1){
	    return ary[0];
	}
	return ary[start+1];
    }
    public E getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(end == 0){
	    return ary[ary.length - 1];
	}
	return ary[end-1];
    }
}
