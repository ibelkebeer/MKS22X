public class MyLinkedList{
    private Node first,last;
    private int length;
    public MyLinkedList(){
	first = new Node();
	last = new Node();
	length = 0;
    }
    public boolean add(Integer val){
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
    public Integer get(int index){
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
    public Integer set(int index,Integer val){
	if(length > 0 && index >= 0 && index < length){
	    Node cur = getNode(index);
	    int temp =  cur.getVal();
	    cur.setVal(val);
	    return temp;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int indexOf(Integer val){
	if(length==1){
	    if(first.getVal() == val){
		return 0;
	    }
	}else{
	    Node cur = first;
	    int temp = 0;
	    for(int x=0; x<length-1; x++){
		if(cur.getVal() == val){
		    return x;
		}
		cur = cur.getNext();
		temp++;
	    }
	    if(cur.getVal() == val){
		return temp;
	    }
	}
	return -1;
    }
    public void add(int index,Integer val){
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
    public Integer remove(int index){
	if(index >= 0 && index < length){
	    Integer temp = 0;
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
    public boolean remove(Integer val){
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
	private Integer data;
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
	public Integer getVal(){
	    return data;
	}
	public void setVal(Integer num){
	    data = num;
	}
    }
}

