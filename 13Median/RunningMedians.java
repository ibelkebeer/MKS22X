import java.util.*;
public class RunningMedians{
    private MyHeap<Double> lo, hi;
    public RunningMedians(){
	lo = new MyHeap<>();
	hi = new MyHeap<>(false);
    }
    public void add(Double element){
	if(lo.size() == 0 || element < lo.peek()){
	    lo.add(element);
	}else{
	    hi.add(element);
	}
	if(lo.size() - hi.size() == 2){
	    hi.add(lo.remove());
	}
	if(hi.size() - lo.size() == 2){
	    lo.add(hi.remove());
	}
    }
    public int size(){
	return lo.size() + hi.size();
    }
    public Double getMedian(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
	if(lo.size() > hi.size()){
	    return lo.peek();
	}
	if(hi.size() > lo.size()){
	    return hi.peek();
	}
	return (lo.peek() + hi.peek()) / 2;
    }
}
