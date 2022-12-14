import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Author: Marius Daniel Boncica- Group project
 * UPDATE 14/12/2022
 */
public class PlayerSingle extends Actor
{
    public String  playerSingleImage;
    public static int scor = 0,  timerPrizeSound = 0, contorPrizeSound = 10, timerBoosterSound = 0, contorBoosterSound = 10;
    static float speed = 1;
    static boolean prizeSoundOn = false, boosterSoundOn = false;
    static GreenfootSound prizeSound = new GreenfootSound("cherry_sound(short_buzzer_sound).wav"), boosterSound = new GreenfootSound("burger_sound(sci_fi_drill_alert).wav");
    public PlayerSingle(String playerSingleImage){
    this.playerSingleImage = playerSingleImage;

    getImage().scale(80,80);  }
    public void act() 
    {
        control();
        addPoints();
        speedBooster();
        moonLaunch();
  fireProjectile();
         
    }
     public void fireProjectile(){
        if(Greenfoot.mousePressed(null)){
             Projectile projectile = new Projectile();
            getWorld().addObject(projectile,getX(),getY());
               projectile.turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    
        }
    }
    /********************* movement ****************************/
    private void control(){
        if( Greenfoot.isKeyDown("down") ){
            setLocation( getX(), getY() + (int)speed );
            getImage().mirrorVertically();}
        if( Greenfoot.isKeyDown("up") )
           { setLocation( getX(), getY() - (int)speed );
            getImage().mirrorVertically();}
        if( Greenfoot.isKeyDown("left") )
            {setLocation( getX() - (int)speed, getY() );
            getImage().mirrorHorizontally();}
        if( Greenfoot.isKeyDown("right") )
            {setLocation( getX() + (int)speed, getY() );
            getImage().mirrorHorizontally();}
        
            
    }
    
    private void addPoints(){
        Actor points = getOneIntersectingObject(prize.class);
        if( isTouching(prize.class)){
            scor++;
            
            Single world = (Single) getWorld();
           
            getWorld().removeObject(points);
            if( !prizeSoundOn )
            {
                prizeSoundOn = true;
                prizeSound.playLoop();
                timerPrizeSound = 1;
            }
            else
                timerPrizeSound = 1;
        }
        else if( prizeSoundOn )
        {
            timerPrizeSound = (timerPrizeSound+1) % contorPrizeSound;
            if( timerPrizeSound == 0 )
            {
                prizeSound.stop();
                prizeSoundOn = false;
            }
        }
    }
   
     private void moonLaunch(){
        Actor moon = getOneIntersectingObject(Moon.class);
            if ( Greenfoot.isKeyDown("space") && PlayerSingle.scor >= 3 && PlayerSingle.scor <10){
          
                getWorld().removeObject(moon);
            
        }if( !prizeSoundOn )
            {
               prizeSoundOn = true;
               prizeSound.playLoop();
               timerPrizeSound = 1;
            }
            else
                timerPrizeSound = 1;
            }
    private void speedBooster(){
        Actor booster = getOneIntersectingObject(speedBooster.class);
        if( isTouching(speedBooster.class) ){
            getWorld().removeObject(booster);
            speed = 120 * speed / 100;
            Single.playerSingleLife.add(1);
            
            if( !boosterSoundOn )
            {
                boosterSoundOn = true;
                boosterSound.playLoop();
                timerBoosterSound = 1;
            }
            else
                timerBoosterSound = 1;
        }
        else if( boosterSoundOn )
        {
            timerBoosterSound = (timerBoosterSound+1) % contorBoosterSound;
            if( timerBoosterSound == 0 )
            {
                boosterSound.stop();
                boosterSoundOn = false;
            }
        }
        
    }
   
}
