import greenfoot.*;
import java.util.Random;
/**
 * *Metauniverse Multiplayer level
 * Author Marius Daniel Boncica
 * updated 14/12/2022
 */
 
/**
 *
 *
 */

public class MyWorld extends World
{
    //create Counter objects for player1 life and player 2 life counters
    public static Counter player1Life = new Counter();
    public static Counter player2Life = new Counter();
    //declare int timer and fix value for 1 minute
    private int timer = 1*60*55; //about 1 min at normal speed
   //initiat mao and create table to arrange objects od specified positions
    int[][] map= { 
{1,1,1,3,1,1,6,1,1,1,1,1,1,1,1,2},
{1,1,1,3,6,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,6,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,6,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{5,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
};
//create object random
    Random randgen = new Random();
    //declare container, timer , Booster 
    public static int the_width = 900, the_height = 600, cell_size = 1;
    int cadran = 1, cadranTimerCounter = 1, cadranTimer = 250, spawnTimerCounterPrize = 0, spawnTimerPrize = 130, spawnTimerCounterBooster = 0, spawnTimerBooster = 260;
  //create objects of players
    Player1 alfa = new Player1("R.png");
   
    Player2 beta = new Player2("R1.png");
    //-----------------CONSTRUCTOR-------------------------
    public MyWorld()
    {    //define world size 
        super(900,600,1);
        //use if function when creating objects and store objects to array
       //array position will be refered in map above
        for(int i = 0; i<16;i++)
        for (int j =0; j<16; j++)
if (map[i][j]==0)
//create object of step1 and add it to array position 0
addObject(new Step1("sunearth.gif"),j*50,i*50);
//create object of Obstacleand add it to array position 2
else if(map[i][j] == 2)
addObject(new Obstacle("blackhole.png"),j*50,i*50);


//create object of Obstacle and add it to array position 3
else if (map[i][j] == 3)
addObject(new Obstacle("beeper.png"),j*50,i*50);
//create object of step1 and add it to array position 4
else if (map[i][j] == 4)
addObject(new Step1("sunearth.gif"),j*50,i*50);
else if (map[i][j] == 5)
addObject(new Asteroid("asteroid.png"),j*50,i*50);
else if (map[i][j] == 6){

addObject(new Obstacle("blackhole.png"),j*50,i*50);}

else if (map[i][j] == 7)

addObject(new Asteroid("asteroid.png"),j*50,i*50);
//call methods for this class object
        prepare();
        continuing();
        addObject(player1Life, 350,20);
        addObject(player2Life, 550,20);
        player1Life.setValue(5);
        player2Life.setValue(5);
        Player1 p1 = new Player1("R.png");
       addObject(p1, 350,400);
       Player2 p2 = new Player2("R1.png");
        addObject(p2,650,400);
    }
    //-------------Set background-------------------
    private void prepare(){
       
        GreenfootImage bkg = getBackground();
        bkg.setColor(Color.BLACK);
        bkg.fill();
        createStars(300);
    }
    //-----------------set music--------------*/
    private void continuing(){
        setMusic();
        tinScor();
        
    }
    //--------------------act method to display timer and score---------------*/
    public void act(){
        if( Greenfoot.mouseClicked(null) )
           addObject(new prize(), 10 + randgen.nextInt()%(getWidth() - 10 + 1), 10 + randgen.nextInt()%(getHeight() - 10 + 1) );

        checkForSpawningPrizes();
        checkForSpawningBoosters();
        
        tinScor();
       alertAsteroid();
         if (--timer == 0)
    {
        removeObjects(getObjects(null)); 
        if(Player1.scor > Player2.scor){
        showText("Player1 WON ||| Score: " + Player1.scor, 350,200);
showText("Player2 Loose ||| Score "+ Player2.scor, 440,300);}

else if(Player1.scor == Player2.scor){
        showText("Player1 and Player2 WON ||| Score:  " + Player1.scor, 450,300);
}
else if(Player1.scor < Player2.scor){showText("Player2 WON ||| Score  " + Player2.scor, 450,200);
showText("Player1 Loose ||| Score  "+ Player1.scor, 450,300);
}

       //create a delay when time end
       Greenfoot.delay(10);
       //quit word and enter new world
        Greenfoot.setWorld(new Menu());
   
    }
  
    }
    //method to animate speed booster object
    private void checkForSpawningBoosters(){
        spawnTimerCounterBooster = (spawnTimerCounterBooster  + 1)%spawnTimerBooster;
        if( spawnTimerCounterBooster == 0){
            addObject(new speedBooster(), 1 + randgen.nextInt()%900, 1 + randgen.nextInt()%600);
            addObject(new speedBooster(), 10 + Greenfoot.getRandomNumber( the_width - 2*10 ), 10 + Greenfoot.getRandomNumber( the_height - 2*10 ) );
            if(spawnTimerBooster == 0) spawnTimerBooster = 260; //initial value
        }
    }
    //method to animate prize object
    private void checkForSpawningPrizes(){
        spawnTimerCounterPrize = (spawnTimerCounterPrize + 1)%spawnTimerPrize;
        if( spawnTimerCounterPrize == 0 ){
            addObject(new prize(), 1 + randgen.nextInt()%900,  1 + randgen.nextInt()%600);
            addObject(new prize(), 10 + Greenfoot.getRandomNumber( the_width - 2*10 ), 10 + Greenfoot.getRandomNumber( the_height - 2*10 ) );
            spawnTimerPrize -= 1; //speed points selectors
            if(spawnTimerPrize == 0) spawnTimerPrize = 130;//initial value
        }
    }
    //set music -create object and declare song, volume and loop 
    private void setMusic(){
       
        GreenfootSound backgroundMusic = new GreenfootSound("nice_sp.mp3");
        backgroundMusic.setVolume(15);
        backgroundMusic.playLoop();
    }
    //method to create stars
    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++)
        {            
             int x = Greenfoot.getRandomNumber( getWidth() );
             int y = Greenfoot.getRandomNumber( getHeight() );
             int color = 150 - Greenfoot.getRandomNumber(120);
             background.setColorAt(x, y, new Color(color,color,color));
        }
    }
   //method Prize OBJECT ON CLICK EVENT
    private void spawnPrize(){
        if( Greenfoot.mouseClicked(null) ){
            addObject(new prize(), 10 + randgen.nextInt()%(getWidth() - 10 + 1), 10 + randgen.nextInt()%(getHeight() - 10 + 1) );
        }
    }
    //method SPEEDbOOSTER ONclick event
    private void spawnSpeedBooster(){
        if( Greenfoot.mouseClicked(null) ){
            addObject(new speedBooster(), 30+randgen.nextInt()%(getWidth() - 60 + 1), 30 + randgen.nextInt()%(getHeight() - 60 + 1) );
        }
    }
    //method score to display score for players
    private void tinScor(){
        // player1:
        showText("Player 1- score: " + Player1.scor, 100, 20);
        showText("Speed: " + (float)((int)(Player1.speed*1000) )/1000, 100, 40);
        // player2 2:
        showText("Player 2- score: " + Player2.scor, 800, 20);
        showText("Speed: " + (float)((int)(Player2.speed*1000) )/1000, 800, 40);
        
        // timer:
      showText("Time left: "+ timer/(60*55) + (timer%(60*55))/55, 450, 100 );
       showText("Position " + cadran, the_width/2, 10);

    }
    //create alert when scor>10 alert to remove asteroid
      private void alertAsteroid(){
        if(Player1.scor>=10 && Player2.scor>=10 ){
            showText("GO TO ASTEROID AND PRESS SPACE TO REMOVE IT", 400, 200);
        }
    }
  
}
