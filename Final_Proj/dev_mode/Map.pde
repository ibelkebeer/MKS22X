public class Map{
  private Line[] game;
  private int delay;
  public Map(float bpm,float duration,int delay){
    game = new Line[int(bpm * duration)];
    for(int i=0; i<game.length; i++){
      game[i] = new Line();
    }
    this.delay = delay;
  }
  public void addD(int row){
    game[row].addD();
  }
  public void addF(int row){
    game[row].addF();
  }
  public void addJ(int row){
    game[row].addJ();
  }
  public void addK(int row){
    game[row].addK();
  }
  public Line getLine(int row){
    return game[row];
  }
}
