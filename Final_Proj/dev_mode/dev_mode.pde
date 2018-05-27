import processing.sound.*;
SoundFile sample;
String audiofile = "Song1.mp3";
String path;
void setup(){
  size(660,660);
  background(255);
  path = sketchPath(audiofile);
  sample = new SoundFile(this,path);
  sample.loop();
}
void draw(){
  background(255);
  fill(250,250,250);
  rect(220,0,55,height-1);
  rect(275,0,55,height-1);
  rect(330,0,55,height-1);
  rect(385,0,55,height-1);
  rect(220,600,55,20);
  rect(275,600,55,20);
  rect(330,600,55,20);
  rect(385,600,55,20);
}
