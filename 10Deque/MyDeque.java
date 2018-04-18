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
    public String toString(){
	String fin = "[";
	for(int i=0; i<size; i++){
	    fin += ary[i] + " ";
	}
	if(size != 0){
	    fin += ary[size-1] + "]";
	}
	return fin;
    }
    public void addFirst(E element){
	if(start >= end){
	    ary[start] = element;
	    start--;
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
	if(end <= start){
	    ary[end] = element;
	    end++;
	    size++;
	}else{
	    resize();
	    ary[end] = element;
	    end++;
	    size++;
	}
    }
    @SuppressWarnings("unchecked")
    public void resize(){
	E[] bigger = (E[])new Object[size + 10]; 
	for(int i=size; i<size+10; i++){
	    bigger[i] = ary[start % size];
	    size++;
	}
	ary = bigger;
	end = 0;
	start = 9;
    }
    public static void main(String[]args){
	MyDeque<Integer> test = new MyDeque<>();
	for(int x=0; x<1; x++){
	    test.addFirst(new Integer(5));
	}
	System.out.println(test);
    }
}
