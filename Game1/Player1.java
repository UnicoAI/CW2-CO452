import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Author: Marius Daniel Boncica- Group project
 * UPDATE 14/12/2022
 */
public class Player1 extends Actor
{
    public String  player1Image;
    public static int scor = 0,  timerPrizeSound = 0, contorPrizeSound = 10, timerBoosterSound = 0, contorBoosterSound = 10;
    static float speed = 5;
    static boolean prizeSoundOn = false, boosterSoundOn = false;
    static GreenfootSound prizeSound = new GreenfootSound("cherry_sound(short_buzzer_sound).wav"), boosterSound = new GreenfootSound("burger_sound(sci_fi_drill_alert).wav");
    public Player1(String player1Image){
    this.player1Image = player1Image;

    getImage().scale(80,80);  }
    public void act() 
    {
        control();
        addPoints();
        speedBooster();
        touchAsteroid();
       
        moonLaunch();
       fireProjectile();
       hitByProjectile2();
       
         
    }
    public void fireProjectile(){
        if(Greenfoot.mousePressed(null)){
             Projectile projectile = new Projectile();
            getWorld().addObject(projectile,getX(),getY());
               projectile.turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    
    }
    }
   
     public void hitByProjectile2(){
        Actor projectile2 = getOneIntersectingObject(Projectile2.class);
        
            if(isTouching(Projectile2.class)){
                getWorld().removeObject(projectile2);
                MyWorld.player1Life.add(-1);
                
                
            }
        }    
    
    /********************* movement ****************************/
    private void control(){
        
        if( Greenfoot.isKeyDown("down") )
            setLocation( getX(), getY() + (int)speed );
        if( Greenfoot.isKeyDown("up") )
            setLocation( getX(), getY() - (int)speed );
        if( Greenfoot.isKeyDown("left") )
            setLocation( getX() - (int)speed, getY() );
        if( Greenfoot.isKeyDown("right") )
            setLocation( getX() + (int)speed, getY() );
        
            
    }
    
    private void addPoints(){
        Actor points = getOneIntersectingObject(prize.class);
        if( isTouching(prize.class) ){
            scor++;
            getWorld().removeObject(points);
            MyWorld world = (MyWorld) getWorld();
           
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
        Actor moon = getOneIntersectingObject(Asteroid.class);
            if ( Greenfoot.isKeyDown("space") && Player1.scor >= 10 && Player1.scor <100){
          
                getWorld().removeObject(moon);
            }
        }
        private void touchAsteroid(){
            
        
        if(isTouching(Asteroid.class)){
        setRotation(getRotation()+40);}
   
        if( !prizeSoundOn )
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
            MyWorld.player1Life.add(1);
            
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
