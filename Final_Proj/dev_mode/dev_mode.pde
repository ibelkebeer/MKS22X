  import processing.sound.*;
  SoundFile sample;
  String audiofile = "Song1.mp3";
  String path;
  float speed = 1;
  void setup(){
    size(660,660);
    background(255);
    path = sketchPath(audiofile);
    sample = new SoundFile(this,path);
    sample.loop();
    rect(0,height-40,100,40);
    rect(100,height-40,100,40);
    rect(200,height-40,100,40);
    rect(300,height-40,100,40);
  }
  void draw(){
    sample.rate(speed);
  }
  boolean overButton(int x, int y, int w, int h)  {
    if (mouseX >= x && mouseX <= x+w && 
        mouseY >= y && mouseY <= y+h) {
      return true;
    }else{
      return false;
    }
  }
  void mouseClicked(){
    if(overButton(0,height-40,100,40)){
      speed = 0.25;
    }
    if(overButton(100,height-40,100,40)){
      speed = 0.5;
    }
    if(overButton(200,height-40,100,40)){
      speed = 1;
    }
    if(overButton(300,height-40,100,40)){
      speed = 2;
    }
  }
