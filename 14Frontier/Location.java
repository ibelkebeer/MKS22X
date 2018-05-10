public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance,steps;
    public Location(int _x, int _y, Location prev, int dist, int step){
	x = _x;
	y = _y;
	previous = prev;
	distance = dist;
	steps = step;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public boolean hasPrev(){
	return previous != null;
    }
    public Location getPrev(){
	return previous;
    }
    public int getSteps(){
	return steps;
    }
    public int compareTo(Location other){
	if(distance < other.distance){
	    return -1;
	}
	if(distance > other.distance){
	    return 1;
	}
	return 0;
    }
}
