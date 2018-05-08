public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int mode){
        frontier = new FrontierQueue();
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    Location cur = frontier.next();
	    if(cur != maze.getStart()){
		maze.set(cur.getX(),cur.getY(),'.');
	    }
	    Location[] neighbors = maze.getNeighbors(cur);
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
	    System.out.println(maze.toStringColor());
	}
	return false;
    }
    public String toString(){
	return maze.toString();
    }
}
