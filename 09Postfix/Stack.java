import java.util.*;
public class Stack<String>{ 
    public LinkedList<Double> list;
    @SuppressWarnings("unchecked")
    public Stack(){	
	list = new LinkedList();
    }
    public void push(Double value){
	list.add(value);
    }
    public Double pop(){
	return list.remove(list.size()-1);
    } 
}
