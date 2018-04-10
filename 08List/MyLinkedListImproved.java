import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node first,last;
    private int length;
    public MyLinkedListImproved(){
	first = new Node();
	last = new Node();
	length = 0;
    }
    public MyLinkedListImprovedIterator iterator(){
	return new MyLinkedListImprovedIterator();
    }
    public boolean add(T val){
        if(length == 0){
	    first.setNext(last);
	    last.setPrev(first);
	    first.setVal(val);
	    length++;
	}else if(length == 1){
	    last.setVal(val);
	    length++;
	}else{
	    Node next = new Node();
	    last.setNext(next);
	    next.setPrev(last);
	    last = next;
	    last.setVal(val);
	    length++;
	}
	return true;
    }
    public void clear(){
	first.setVal(null);
	last.setVal(null);
	first.setNext(null);
	last.setPrev(null);
	length = 0;
    }
    public T get(int index){
	if(length > 0 && index >= 0 && index < length){
	    return getNode(index).getVal();
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public String toString(){
	String fin = "[";
	if(length == 1){
	    fin += first.getVal();
	}else{
	    Node cur = first;
	    for(int x=0; x<length-1; x++){
		fin += cur.getVal() + ",";
		cur = cur.getNext();
	    }
	    fin += cur.getVal();
	}
	return fin + "]";
    }
    public int size(){
	return length;
    }
    public T set(int index,T val){
	if(length > 0 && index >= 0 && index < length){
	    Node cur = getNode(index);
	    T temp =  cur.getVal();
	    cur.setVal(val);
	    return temp;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int indexOf(T val){
	if(length==1){
	    if(first.getVal().equals(val)){
		return 0;
	    }
	}else{
	    Node cur = first;
	    int temp = 0;
	    for(int x=0; x<length-1; x++){
		if(cur.getVal().equals(val)){
		    return x;
		}
		cur = cur.getNext();
		temp++;
	    }
	    if(cur.getVal().equals(val)){
		return temp;
	    }
	}
	return -1;
    }
    public void add(int index,T val){
	if(index >= 0 && index <= length){
	    Node add = new Node();
	    add.setVal(val);
	    if(index == 0){
		if(length == 0){
		    first.setNext(last);
		    last.setPrev(first);
		    first.setVal(val);
		}else if(length == 1){
		    last.setVal(first.getVal());
		    first.setVal(val);
		}else{
		    add.setNext(first);
		    first.setPrev(add);
		    first = add;
		}
	    }else if(index == length){
		if(length == 1){
		    last.setVal(val);
		}else{
		    add.setPrev(last);
		    last.setNext(add);
		    last = add;
		}
	    }else{
		Node before = getNode(index-1);
		Node after = getNode(index);
		before.setNext(add);
		after.setPrev(add);
		add.setPrev(before);
		add.setNext(after);
	    }
	    length++;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public T remove(int index){
	if(index >= 0 && index < length){
	    T temp;
	    Node cur = getNode(index);
	    if(index == 0){
		temp = first.getVal();
		if(length == 1){
		    first.setNext(null);
		    last.setPrev(null);
		    first.setVal(null);
		}else if(length == 2){
		    first.setVal(last.getVal());
		    last.setVal(null);
		}else{
		    cur.getNext().setPrev(null);
		    first = cur.getNext();
		}
	    }else if(index == length-1){
		temp = cur.getVal();
		if(length == 2){
		    cur.setVal(null);
		}else{
		    cur.getPrev().setNext(null);
		    last = cur.getPrev();
		}
	    }else{
		temp = cur.getVal();
		cur.getPrev().setNext(cur.getNext());
		cur.getNext().setPrev(cur.getPrev());
	    }
	    length--;
	    return temp;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public boolean remove(T val){
	if(first.getVal().equals(val)){
	    if(length == 1){
		first.setNext(null);
		last.setPrev(null);
		first.setVal(null);
	    }else if(length == 2){
		first.setVal(last.getVal());
		last.setVal(null);
	    }else{
		first.getNext().setPrev(null);
		first = first.getNext();
	    }
	    length--;
	    return true;
	}else{
	    Node cur = first;
	    for(int x=0; x<length-1; x++){
		if(cur.getVal().equals(val)){
		    cur.getPrev().setNext(cur.getNext());
		    cur.getNext().setPrev(cur.getPrev());
		    length--;
		    return true;
		}
		cur = cur.getNext();
	    }
	    if(cur.getVal().equals(val)){
		if(length == 2){
		    last.setVal(null);
		}else{
		    cur.getPrev().setNext(null);
		    last = cur.getPrev();
		}
		length--;
		return true;
	    }
	}
	return false;
    }
    private Node getNode(int index){
	Node cur = first;
	for(int x=0; x<index; x++){
	    cur = cur.getNext();
	}
	return cur;
    }
    private class Node{
	private Node next,prev;
	private T data;
	public void setNext(Node add){
	    next = add;
	}
	public void setPrev(Node add){
	    prev = add;
	}
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public T getVal(){
	    return data;
	}
	public void setVal(T val){
	    data = val;
	}
    }
    private class MyLinkedListImprovedIterator implements Iterator<T>{
	Node cur = first;
	T temp;
	public MyLinkedListImprovedIterator(){
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
	public boolean hasNext(){
	    if(cur.getVal() == null){
		cur.setVal(temp);
		return false;
	    }
	    return true;
	}
	public T next(){
	    if(cur.getNext() == null){
		temp = cur.getVal();
		cur.setVal(null);
		return temp;
	    }
	    cur = cur.getNext();
	    return cur.getPrev().getVal();
	}
    }
    public int max(){
	if(length > 0){
	    T max = first.getVal();
	    for(T next: this){
		if(next.compareTo(max) == 1){
		    max = next;
		}
	    }
	    return indexOf(max);
	}
	return -1;
    }
    public int min(){
	if(length > 0){
	    T min = first.getVal();
	    for(T next: this){
		if(next.compareTo(min) == -1){
		    min = next;
		}
	    }
	    return indexOf(min);
	}
	return -1;
    }
}

