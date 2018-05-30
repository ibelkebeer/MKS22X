public class Map{
  private Line[] game;
  private int delay;
  public Map(float bpm,float duration,int delay){
    game = new Line[int(bpm * duration * 4) + 10];
    for(int i=0; i<game.length; i++){
      game[i] = new Line();
    }
    this.delay = delay;
  }
  public void setD(int row,int val){
    game[row].setD(val);
  }
  public void setF(int row,int val){
    game[row].setF(val);
  }
  public void setJ(int row,int val){
    game[row].setJ(val);
  }
  public void setK(int row,int val){
    game[row].setK(val);
  } 
  public Line getLine(int row){
    return game[row];
  }
}
