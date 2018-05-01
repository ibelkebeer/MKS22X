import java.util.*;
public class RunningMedians{
    private MyHeap<Double> lo, hi;
    public RunningMedians(){
	lo = new MyHeap<>();
	hi = new MyHeap<>(false);
    }
    public void add(Double element){
	if(lo.size() == 0 && hi.size() == 0){
	    lo.add(element);
	}else if(lo.size() - hi.size() == 1 && element < hi.peek()){
	    if(element < lo.peek()){
		hi.add(lo.remove());
		lo.add(element);
	    }else{
		hi.add(element);
	    }
	}else if(hi.size() - lo.size() == 1 && element > lo.peek()){
	    if(element > hi.peek()){
		lo.add(hi.remove());
		hi.add(element);
	    }else{
		hi.add(element);
	    }
	}else if(element <= lo.peek()){
	    lo.add(element);
	}else{
	    hi.add(element);
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
