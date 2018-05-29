import processing.sound.*;
SoundFile sample;
Pulse pulse;
String audiofile = "Song2.mp3";
String path;
float speed = 1;
float offset = 0;
float bpm;
float time;
float ellapsedTime;
float lineY;
int mode = 0;
Map game;
void setup(){
  size(660,660);
  background(255);
  time = millis();
  pulse = new Pulse(this);
  pulse.freq(1.5);
  pulse.amp(1);
  path = sketchPath(audiofile);
  sample = new SoundFile(this,path);
  sample.loop();
  lineY = 640;
}
void draw(){
  sample.rate(speed);
  background(255);
  fill(255);
  rect(0,height-40,100,40);
  rect(100,height-40,100,40);
  rect(200,height-40,100,40);
  rect(300,height-40,100,40);
  rect(0,height-80,100,40);
  rect(100,height-80,100,40);
  rect(200,height-80,100,40);
  rect(300,height-80,100,40);
  rect(400,0,65,660);
  rect(465,0,65,660);
  rect(530,0,65,660);
  rect(595,0,65,660);
  increment();
  for(float i=lineY; i>=0; i-=20){
    line(400,i,660,i);
  }
  if(mode == 1){
    rect(mouseX-32.5,mouseY-10,65,20);
  }
}
boolean overButton(int x, int y, int w, int h){
  return mouseX >= x && mouseX <= x+w && mouseY >= y && mouseY <= y+h;
}
void increment(){
  lineY++;
  if(lineY == 660){
    lineY = 640;
  }
}
void mouseClicked(){
  if(overButton(0,height-40,100,40)){
    speed = 0.25;
  }
  if(overButton(100,height-40,100,40)){
    speed = 1;
  }
  if(overButton(200,height-40,100,40)){
    lineY = 640;
  }
  if(overButton(300,height-40,100,40)){
    sample.stop();
    sample.play();
  }
  if(overButton(0,height-80,100,40)){
    mode = 1;
  }
}
