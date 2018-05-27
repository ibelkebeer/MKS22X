import processing.sound.*;
SoundFile sample;
Pulse pulse;
String audiofile = "Song1.mp3";
String path;
float speed = 1;
float offset;
float bpm;
float time;
float ellapsedTime;
void setup(){
  size(660,660);
  background(255);
  time = millis();
  pulse = new Pulse(this);
  bpm = 151/60;
  pulse.freq(bpm);
  //pulse.play();
  path = sketchPath(audiofile);
  sample = new SoundFile(this,path);
  sample.loop();
}
void draw(){
  sample.rate(speed);
  background(255);
  fill(255);
  rect(0,height-40,100,40);
  rect(100,height-40,100,40);
  rect(200,height-40,100,40);
  rect(300,height-40,100,40);
  rect(400,height-40,100,40);
  float passedTime = (millis() - time) * speed;
  ellapsedTime += passedTime;
  textSize(32);
  fill(0,102,53);
  text(String.valueOf(ellapsedTime),100,100);
}
boolean overButton(int x, int y, int w, int h){
  return mouseX >= x && mouseX <= x+w && mouseY >= y && mouseY <= y+h;
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
  if(overButton(400,height-40,100,40)){
    sample.stop();
    sample.play();
    time = millis();
    ellapsedTime = 0;
  }
}
