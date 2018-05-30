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
float pauseTime;
int startD = -1;
int startF = -1;
int startJ = -1;
int startK = -1;
boolean paused = false;
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
  rect(400,height-120,260,40);
  fill(250,0,0);
  textSize(32);
  text("*.25",0,height);
  text("*1",100,height);
  text("*2",200,height);
  text("reset",300,height);
  text("note",0,height-40);
  text("save",300,height-40);
  textSize(18);
  text("hold-note",100,height-40);
  text("remove",200,height-40);
  fill(75,250,250);
  if(mode == 1){
    rect(mouseX-32.5,mouseY-20,65,40);
  }
  fill(250,0,250);
  if(mode == 2){
    rect(mouseX-32.5,mouseY-20,65,40);
  }
  if(!paused){
    move();
  }else{
    drawLines();
  }
}
void move(){
  for(float i=lineY; i>=0; i-=40){
    line(400,i,660,i);
    fill(75,250,250);
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getD() == 1){
      rect(400,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getF() == 1){
      rect(465,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getJ() == 1){
      rect(530,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getK() == 1){
      rect(595,i,65,40);
    }
    fill(250,0,250);
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getD() == 2){
      rect(400,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getF() == 2){
      rect(465,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getJ() == 2){
      rect(530,i,65,40);
    }
    if(game.getLine((Math.abs(int(i-659)) / 40)+line).getK() == 2){
      rect(595,i,65,40);
    }
  }
  increment();  
}
void drawLines(){
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
}
boolean overButton(int x, int y, int w, int h){
  return mouseX >= x && mouseX <= x+w && mouseY >= y && mouseY <= y+h;
}
void increment(){
  lineY += speed * 4;
  if(lineY >= 660){
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
    paused = false;
    sample.stop();
    sample.jump(0);
    ellapsedTime = 0;
    time = millis();
    lineY = 640;
    line = 0;
  }
  if(overButton(0,height-80,100,40)){
    if(mode == 2){
      if(startD != -1){
        game.setD(startD,0);
        startD = 0;
      }
      if(startF != -1){
        game.setF(startF,0);
        startF = 0;
      }
      if(startJ != -1){
        game.setJ(startJ,0);
        startJ = 0;
      }
      if(startK != -1){
        game.setK(startK,0);
        startK = 0;
      }
    }
    mode = 1;
  }
  if(overButton(100,height-80,100,40)){
    mode = 2;
  }
  if(overButton(200,height-80,100,40)){
    if(mode == 2){
      if(startD != -1){
        game.setD(startD,0);
        startD = 0;
      }
      if(startF != -1){
        game.setF(startF,0);
        startF = 0;
      }
      if(startJ != -1){
        game.setJ(startJ,0);
        startJ = 0;
      }
      if(startK != -1){
        game.setK(startK,0);
        startK = 0;
      }
    }
    mode = 3;
  }
  if(overButton(300,height-80,100,40)){
  }
  if(mode == 1 && overButton(400,0,260,660)){
    if(mouseX < 465){
      game.setD((Math.abs(int(mouseY)-659) / 40)+line,1);
    }
    else if(mouseX < 530){
      game.setF((Math.abs(int(mouseY)-659) / 40)+line,1);
    }
    else if(mouseX < 595){
      game.setJ((Math.abs(int(mouseY)-659) / 40)+line,1);
    }
    else{
      game.setK((Math.abs(int(mouseY)-659) / 40)+line,1);
    }
  }
  if(mode == 2 && overButton(400,0,260,660)){
    if(mouseX < 465){
      if(startD == -1){
        game.setD((Math.abs(int(mouseY)-659) / 40)+line,2);
        startD = (Math.abs(int(mouseY)-659) / 40)+line;
      }else{
        if((Math.abs(int(mouseY)-659) / 40)+line < startD){
          game.setD(startD,0);
          game.setD((Math.abs(int(mouseY)-659) / 40)+line,2);
          startD = (Math.abs(int(mouseY)-659) / 40)+line;
        }else{
          for(int i = startD; i<=(Math.abs(int(mouseY)-659) / 40)+line; i++){
            game.setD(i,2);
          }
          startD = -1;
        }
      }
    }else if(mouseX < 530){
      if(startF == -1){
        game.setF((Math.abs(int(mouseY)-659) / 40)+line,2);
        startF = (Math.abs(int(mouseY)-659) / 40)+line;
      }else{
        if((Math.abs(int(mouseY)-659) / 40)+line < startF){
          game.setF(startF,0);
          game.setF((Math.abs(int(mouseY)-659) / 40)+line,2);
          startF = (Math.abs(int(mouseY)-659) / 40)+line;
        }else{
          for(int i = startF; i<=(Math.abs(int(mouseY)-659) / 40)+line; i++){
            game.setF(i,2);
          }
          startF = -1;
        }
      }
    }else if(mouseX < 595){
      if(startJ == -1){
        game.setJ((Math.abs(int(mouseY)-659) / 40)+line,2);
        startJ = (Math.abs(int(mouseY)-659) / 40)+line;
      }else{
        if((Math.abs(int(mouseY)-659) / 40)+line < startJ){
          game.setJ(startJ,0);
          game.setJ((Math.abs(int(mouseY)-659) / 40)+line,2);
          startJ = (Math.abs(int(mouseY)-659) / 40)+line;
        }else{
          for(int i = startJ; i<=(Math.abs(int(mouseY)-659) / 40)+line; i++){
            game.setF(i,2);
          }
          startJ = -1;
        }
      }
    }else{
      if(startK == -1){
        game.setK((Math.abs(int(mouseY)-659) / 40)+line,2);
        startK = (Math.abs(int(mouseY)-659) / 40)+line;
      }else{
        if((Math.abs(int(mouseY)-659) / 40)+line < startK){
          game.setK(startK,0);
          game.setK((Math.abs(int(mouseY)-659) / 40)+line,2);
          startK = (Math.abs(int(mouseY)-659) / 40)+line;
        }else{
          for(int i = startD; i<=(Math.abs(int(mouseY)-659) / 40)+line; i++){
            game.setK(i,2);
          }
          startK = -1;
        }
      }
    }
  }
  if(mode == 3 && overButton(400,0,260,660)){
    if(mouseX < 465){
      game.setD((Math.abs(int(mouseY)-659) / 40)+line,0);
    }
    else if(mouseX < 530){
      game.setF((Math.abs(int(mouseY)-659) / 40)+line,0);
    }
    else if(mouseX < 595){
      game.setJ((Math.abs(int(mouseY)-659) / 40)+line,0);
    }
    else{
      game.setK((Math.abs(int(mouseY)-659) / 40)+line,0);
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
  if(key == ' '){
    if(!paused){
      paused = true;
      sample.stop();
      pauseTime = millis();
    }else{
      time += millis() - pauseTime;
      ellapsedTime = millis() - time;
      sample.jump(ellapsedTime/1000);
      paused = false;
    }
  }
}
