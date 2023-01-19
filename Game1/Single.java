import greenfoot.*;
import java.util.Random;
/**
 * Author Marius Daniel Boncica
 * updated 14/12/2022
 */
 
/**
 *
 *
 */

public class Single extends World
{
    public static Counter playerSingleLife = new Counter();
    
    
    private int timer = 1*60*55; //about 1 min at normal speed
    int[][] map= { 
{1,1,1,3,1,1,6,1,1,1,1,1,1,1,7,2},
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
    Random randgen = new Random();
    public static int the_width = 900, the_height = 600, cell_size = 1;
    int spawnTimerCounterPrize = 0, spawnTimerPrize = 130, spawnTimerCounterBooster = 0, spawnTimerBooster = 260;
  
    PlayerSingle alfa = new PlayerSingle("R1.png");
  
   
    
    //-----------------CONSTRUCTOR-------------------------
    public Single()
    {    
        super(900,600,1);
        for(int i = 0; i<16;i++)
        for (int j =0; j<16; j++)
if (map[i][j]==0)

addObject(new Step1("sunearth.gif"),j*50,i*50);

else if(map[i][j] == 2)
addObject(new Obstacle("blackhole.png"),j*50,i*50);



else if (map[i][j] == 3)
addObject(new Obstacle("beeper.png"),j*50,i*50);

else if (map[i][j] == 4)
addObject(new Step1("sunearth.gif"),j*50,i*50);
else if (map[i][j] == 5)
addObject(new Asteroid("asteroid.png"),j*50,i*50);
else if (map[i][j] == 6){

addObject(new Obstacle("blackhole.png"),j*50,i*50);}

else if (map[i][j] == 7)

addObject(new Nextworld("sun.gif"),j*50,i*50);

        prepare();
        continuing();
        addObject(new PlayerSingle("R1.png"),450,450);
        addObject(playerSingleLife, 470,20);
       
        playerSingleLife.setValue(0);
       
       
        
    }
    //-------------Set Cadrans for both players-------------------
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
    //--------------------change cadran---------------*/
    public void act(){
        if( Greenfoot.mouseClicked(null) )
           addObject(new prize(), 10 + randgen.nextInt()%(getWidth() - 10 + 1), 10 + randgen.nextInt()%(getHeight() - 10 + 1) );

        checkForSpawningPrizes();
        checkForSpawningBoosters();
       
        tinScor();
      
       
         if (--timer == 0)
    {
        removeObjects(getObjects(null)); 
        if(Player1.scor > 0 ){
        showText("YOU WON ||| Score: " + PlayerSingle.scor, 350,200);
}

else if(Player1.scor == 0){
        showText("Try Again " + PlayerSingle.scor, 450,300);
}
     Greenfoot.delay(10);
    Greenfoot.setWorld(new Quit());
        //quit world

    
    }
      
    }
  
    private void checkForSpawningBoosters(){
        spawnTimerCounterBooster = (spawnTimerCounterBooster  + 1)%spawnTimerBooster;
        if( spawnTimerCounterBooster == 0){
            addObject(new speedBooster(), 1 + randgen.nextInt()%900, 1 + randgen.nextInt()%600);
            addObject(new speedBooster(), 10 + Greenfoot.getRandomNumber( the_width - 2*10 ), 10 + Greenfoot.getRandomNumber( the_height - 2*10 ) );
            if(spawnTimerBooster == 0) spawnTimerBooster = 260; //initial value
        }
    }
    private void checkForSpawningPrizes(){
        spawnTimerCounterPrize = (spawnTimerCounterPrize + 1)%spawnTimerPrize;
        if( spawnTimerCounterPrize == 0 ){
            addObject(new prize(), 1 + randgen.nextInt()%900,  1 + randgen.nextInt()%600);
            addObject(new prize(), 10 + Greenfoot.getRandomNumber( the_width - 2*10 ), 10 + Greenfoot.getRandomNumber( the_height - 2*10 ) );
            spawnTimerPrize -= 1; //speed points selectors
            if(spawnTimerPrize == 0) spawnTimerPrize = 130;//initial value
        }
    }
    private void setMusic(){
        /*
         * disclaimer for the song:
         * Skrillex - Scary Monsters And Nice Sprites
         */
        GreenfootSound backgroundMusic = new GreenfootSound("nice_sp.mp3");
        backgroundMusic.setVolume(15);
        backgroundMusic.playLoop();
    }
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
    /** function price */
    private void spawnPrize(){
        if( Greenfoot.mouseClicked(null) ){
            addObject(new prize(), 10 + randgen.nextInt()%(getWidth() - 10 + 1), 10 + randgen.nextInt()%(getHeight() - 10 + 1) );
        }
    }
    private void spawnSpeedBooster(){
        if( Greenfoot.mouseClicked(null) ){
            addObject(new speedBooster(), 30+randgen.nextInt()%(getWidth() - 60 + 1), 30 + randgen.nextInt()%(getHeight() - 60 + 1) );
        }
    }
    private void tinScor(){
        // player1:
        showText("Score: " + PlayerSingle.scor, 100, 20);
        showText("Speed: " + (float)((int)(PlayerSingle.speed*1000) )/1000, 100, 40);
       
        // timer:
      showText("Time left: "+ timer/(60*55) + (timer%(60*55))/55, 450, 100 );
       

    }
  
}
