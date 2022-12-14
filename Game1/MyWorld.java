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
public class MyWorld extends World
{int[][] map= { 
{1,1,1,3,1,1,6,1,1,1,3,1,1,1,7,1},
{1,1,1,3,6,3,3,1,1,1,6,1,1,1,1,1,1,1},
{1,1,1,3,3,5,1,1,1,1,5,1,1,1,1,1},
{1,1,1,6,3,1,1,1,1,5,1,1,1,1,1,1},
{1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,1},
{1,1,1,1,1,1,1,1,6,1,1,1,1,1,1,1},
{1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1},
{1,1,1,2,2,1,1,5,1,1,5,1,1,1,1,1},
{1,1,1,2,2,1,1,6,1,6,1,1,1,1,1,1},
{1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1},
{5,1,1,1,1,1,1,5,1,1,1,1,1,5,1,1},
{1,1,1,5,1,1,1,1,1,1,5,1,1,1,1,1},
{5,1,1,1,1,1,1,5,1,1,1,1,1,5,1,1},
{1,1,1,5,1,1,1,1,1,1,5,1,1,1,1,1}
};
    Random randgen = new Random();
    public static int the_width = 900, the_height = 600, cell_size = 1;
    int cadran = 1, cadranTimerCounter = 1, cadranTimer = 250, spawnTimerCounterPrize = 0, spawnTimerPrize = 130, spawnTimerCounterBooster = 0, spawnTimerBooster = 260;
    
    Player1 alfa = new Player1();
    Player2 beta = new Player2();
    //-----------------CONSTRUCTOR-------------------------
    public MyWorld()
    {    
        super(the_width, the_height, cell_size);
        for(int i = 0; i<16;i++)
        for (int j =0; j<16; j++)
if (map[i][j]==0)

addObject(new Step1("universe.jpeg"),j*50,i*50);

else if(map[i][j] == 2)
addObject(new Step1("steel-ball.png"),j*50,i*50);



else if (map[i][j] == 3)
addObject(new Step1("space.gif"),j*50,i*50);

else if (map[i][j] == 4)
addObject(new Step1("steel-ball.png"),j*50,i*50);
else if (map[i][j] == 5)
addObject(new Obstacle("steel-ball.png"),j*50,i*50);
else if (map[i][j] == 6){

addObject(new Obstacle("airplane.png"),j*50,i*50);}

else if (map[i][j] == 7)

addObject(new Nextworld("lift-open.png"),j*50,i*50);

        prepare();
        continuing();
        
    }
    //-------------Set Cadrans for both players-------------------
    private void prepare(){
        alfa.cadran = cadran;
        beta.cadran = cadran;
        int x1, y1, x2, y2;
        x1 = 50 + Math.abs( 50 + randgen.nextInt()%51 );
        y1 = 50 + Math.abs( 50 + randgen.nextInt()%51 );
        x2 = 50 + Math.abs( the_width-150 + randgen.nextInt()%51 );
        y2 = 50 + Math.abs( the_height-150 + randgen.nextInt()%51 );

        addObject(alfa, x1, y1);/** alfa cadran1: |---------------------------|                 |--------------------------| */
        /**                | ----------------------    |  beta  cadran2
         * :  |                          | */
        addObject(beta, x2, y2);/**                | |50x50               |    |                 |                          | */
        /**                | |                    |    |                 |   |--------------------| | */
        /**                | |                    |    |                 |   |750x450             | | */
        /**                | |             100x100|    |                 |   |            800x500 | | */
        /**                | ----------------------    |                 |   |                    | | */
        /**                |                           |                 |   |                    | | */
        /**                |                           |                 |   ---------------------- | */
        /**                |___________________________|                 |__________________________| */

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
        changeCadran(alfa, beta);
        tinScor();
    }
    private void changeCadran(Player1 first, Player2 second){
        cadranTimerCounter = (cadranTimerCounter + 1) % cadranTimer;
        if(cadranTimerCounter == 0){
            int old = cadran;
            while(cadran == old)
                cadran = 1 + (randgen.nextInt() % 4);
            first.cadran = cadran;
            second.cadran = cadran;
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
        // JUCATOR 1:
        showText("Player 1- score: " + Player1.scor, 100, 577);
        showText("Speed: " + (float)((int)(Player1.speed*1000) )/1000, 70, 593);
        // JUCATOR 2:
        showText("Player 2- score: " + Player2.scor, 795, 577);
        showText("Speed: " + (float)((int)(Player2.speed*1000) )/1000, 826, 593);
        
        // ALTELE:
        showText("Cadran " + cadran, the_width/2, 10);

    }
}
