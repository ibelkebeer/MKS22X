import java.util.*;
public class FrontierQueue implements Frontier{
    private Queue<Location> queue;
    public FrontierQueue(){
	queue = new LinkedList<>();
    }
    public boolean hasNext(){
	return queue.size() > 0;
    }
    public void add(Location n){
	queue.add(n);
    }
    public Location next(){
	return queue.remove();
    }
}
