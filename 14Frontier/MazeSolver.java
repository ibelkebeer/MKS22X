public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    private boolean AStar;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
	animate = false;
	AStar = false;
    }

    public boolean solve(){
	return solve(2);
    }

    public void setAStar(boolean mode){
	AStar = mode;
    }

    public void setAnimate(boolean mode){
	animate = mode;
    }

    public boolean solve(int mode){
	if(mode == 0){
	    frontier = new FrontierQueue();
	}else if(mode == 1){
	    frontier = new FrontierStack();
	}else if(mode == 2 || mode == 3){
	    frontier = new FrontierPriorityQueue();
	}else{
	    throw new IllegalArgumentException();
	}
	if(mode == 3){
	    setAStar(true);
	}
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    Location cur = frontier.next();
	    Location[] neighbors;
	    if(cur != maze.getStart()){
		maze.set(cur.getX(),cur.getY(),'.');
	    }
	    if(AStar){
		neighbors = maze.getNeighbors(cur,1);
	    }else{
		neighbors = maze.getNeighbors(cur,0);
	    }
	    for(int i=0; i<4; i++){
		if(neighbors[i] != null){
		    if(maze.get(neighbors[i].getX(),neighbors[i].getY()) == 'E'){
			while(neighbors[i].hasPrev()){
			    neighbors[i] = neighbors[i].getPrev();
			    maze.set(neighbors[i].getX(),neighbors[i].getY(),'@');
			}
			return true;
		    }else{
			frontier.add(neighbors[i]);
			maze.set(neighbors[i].getX(),neighbors[i].getY(),'?');
		    }
		}
	    }
	    if(animate){
		System.out.println(maze.toStringColor());
	    }
	}
	return false;
    }
    public String toString(){
	return maze.toString();
    }
}
