import processing.sound.*;
public class Map{
  private Line[] game;
  private String name;
  private int size;
  private float bpm;
  private SoundFile sample;
  private SoundFile hit;
  private PrintWriter output;
  public Map(SoundFile sample,SoundFile effect,float bpm,String name){
    game = new Line[int(bpm * sample.duration() * 8) + 100];
    for(int i=0; i<game.length; i++){
      game[i] = new Line();
    }
    this.bpm = bpm;
    this.name = name + ".txt";
    size = 7200 / int(bpm);
    this.sample = sample;
    hit = effect;
  }
  public void play(){
    sample.play();
    sample.add(20000.0);
  }
  public void jump(float time){
    sample.jump(time);
  }
  public void stop(){
    sample.stop();
  }
  public void rate(float speed){
    sample.rate(speed);
  }
  public int size(){
    return size;
  }
  public float bpm(){
    return bpm;
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
  public void hit(){
    hit.play();
  }
  public void save(){
    output = createWriter(name);
    for(int i=0; i<60; i++){
      output.println("0000");
    }
    for(int i=0; i<game.length; i++){
      output.println("" + game[i].getD() + game[i].getF() + game[i].getJ() + game[i].getK());
    }
    output.flush();
    output.close();
  }
}
