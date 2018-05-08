import java.util.*;
public class FrontierStack implements Frontier{
    private Stack<Location> stack;
    public FrontierStack(){
	stack = new Stack<>();
    }
    public boolean hasNext(){
	return !stack.empty();
    }
    public void add(Location n){
	stack.push(n);
    }
    public Location next(){
	return stack.pop();
    }
}
