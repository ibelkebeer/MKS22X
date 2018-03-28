public class MyLinkedList{
    private Node first,last;
    private int length;
    public MyLinkedList(){
	first = new Node();
	last = new Node();
	length = 0;
    }
    public boolean add(int val){
        if(length == 0){
	    first.setNext(last);
	    length++;
	}else{
	    Node next = new Node();
	    last.setNext(next);
	    last = next;
	}
    }
    public int get(int index){
	if(length > 0 && index >= 0 && index < length){
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
}
private class Node{
    private Node next,prev;
    private int data;
    public void setNext(){
    }
    public void setPrev(){
    }
    public Node getNext(){
    }
    public Node getPrev(){
    }
    public int getVal(){
    }
    public String toString(){
	String fin = "" + data;
	System.out.println(fin);
    }
}
