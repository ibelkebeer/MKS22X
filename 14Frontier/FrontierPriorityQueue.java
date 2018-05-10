import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> data;
    public FrontierPriorityQueue(){
	data = new MyHeap<>(false);
    }
    public boolean hasNext(){
	return data.size() > 0;
    }
    public void add(Location n){
	data.add(n);
    }
    public Location next(){
	return data.remove();
    }
}
