import processing.sound.*;
SoundFile sample;
String audiofile = "Song2.mp3";
String path;
float speed = 1;
float bpm;
float lineY = 620;
int mode = 0;
int line = 0;
float time;
float ellapsedTime;
Map game;
void setup(){
  size(660,660);
  background(255);
  path = sketchPath(audiofile);
  sample = new SoundFile(this,path);
  sample.cue(.1);
  sample.loop();
  time = millis();
  ellapsedTime = 0;
  game = new Map(180,sample.duration(),2);
}
void draw(){
  sample.rate(speed);
  ellapsedTime = millis() - time;
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
  fill(75,250,250);
  if(mode == 1){
    rect(mouseX-32.5,mouseY-20,65,40);
  }
  for(float i=lineY; i>=0; i-=40){
    line(400,i,660,i);
    if(game.getLine((Math.abs(int(i-660)) / 40)+line).getD() == 1){
      rect(400,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-660)) / 40)+line).getF() == 1){
      rect(465,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-660)) / 40)+line).getJ() == 1){
      rect(530,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-660)) / 40)+line).getK() == 1){
      rect(595,i,65,40);
    }
  }
  increment();  
}
boolean overButton(int x, int y, int w, int h){
  return mouseX >= x && mouseX <= x+w && mouseY >= y && mouseY <= y+h;
}
void increment(){
  lineY += 1 * speed * 4;
  if(lineY == 660){
    lineY = 620;
    line++;
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
    speed = 2;
  }
  if(overButton(300,height-40,100,40)){
    sample.stop();
    sample.loop();
    ellapsedTime = 0;
    time = millis();
    lineY = 640;
    line = 0;
  }
  if(overButton(0,height-80,100,40)){
    mode = 1;
  }
  if(mode == 1 && overButton(400,0,260,660)){
    if(mouseX < 465){
      game.addD((Math.abs(int(mouseY)-660) / 40)+line);
    }
    else if(mouseX < 530){
      game.addF((Math.abs(int(mouseY)-660) / 40)+line);
    }
    else if(mouseX < 595){
      game.addJ((Math.abs(int(mouseY)-660) / 40)+line);
    }
    else{
      game.addK((Math.abs(int(mouseY)-660) / 40)+line);
    }
  }
}
void keyPressed(){
  if(key == CODED){
    if(keyCode == LEFT){
      if(ellapsedTime >= 1){
        time += 1000;
        ellapsedTime = millis() - time;
        sample.jump(ellapsedTime/1000);
        line -= 6;
      }
    }
    if(keyCode == RIGHT){
      if(ellapsedTime <= sample.duration() * 1000){
        time -= 1000;
        ellapsedTime = millis() - time;
        sample.jump(ellapsedTime/1000);
        line += 6;
      }
    }
  }
}
