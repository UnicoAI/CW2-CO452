import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Author Marius Daniel Boncica
 * updated 14/12/2022
 */
public class Player2 extends Actor
{
    public String player2Image;

    static int scor = 0, timerPrizeSound = 0,  contorPrizeSound = 10, timerBoosterSound = 0, contorBoosterSound = 10;
    static float speed = 5;
    static boolean prizeSoundOn = false, boosterSoundOn = false;
    static GreenfootSound prizeSound = new GreenfootSound("cherry_sound(short_buzzer_sound).wav"), boosterSound = new GreenfootSound("burger_sound(sci_fi_drill_alert).wav");
     public Player2(String player2Image){
    this.player2Image = player2Image;
    setImage(this.player2Image);
    getImage().scale(100,100);  }
    public void act() 
    {
        control();
        earnPoints();
        speedBooster();
        touchAsteroid();
       
        moonLaunch();
        fireProjectile();
        hitByProjectile1();
    }
     public void fireProjectile(){
        if(Greenfoot.isKeyDown("Q")){
             Projectile2 projectile = new Projectile2();
            getWorld().addObject(projectile,getX(),getY());
               projectile.turnTowards(450,0);
    
    }
    }
     
        
    
    /********************* movement*******************/
    private void control(){
        if( Greenfoot.isKeyDown("w") )
            setLocation( getX(), getY() - (int)speed);
        if( Greenfoot.isKeyDown("s") )
            setLocation( getX(), getY() + (int)speed);
        if( Greenfoot.isKeyDown("a") )
            setLocation( getX() - (int)speed, getY() );
        if( Greenfoot.isKeyDown("d") )
            setLocation( getX() + (int)speed, getY() );
    }
     private void moonLaunch(){
        Actor moon = getOneIntersectingObject(Asteroid.class);
            if ( Greenfoot.isKeyDown("space") && Player2.scor >= 10 && Player1.scor <100){
          
                getWorld().removeObject(moon);}
            }
            public void touchAsteroid(){
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
            
            
    private void earnPoints(){
        Actor price = getOneIntersectingObject(prize.class);
        
        if( isTouching(prize.class) ){
            scor++;
            getWorld().removeObject(price);
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
        else if( prizeSoundOn ){
            timerPrizeSound = (timerPrizeSound+1) % contorPrizeSound;
            if( timerPrizeSound == 0 ){
                prizeSound.stop();
                prizeSoundOn = false;
            }
        }
    }
    private void speedBooster(){
        Actor booster = getOneIntersectingObject(speedBooster.class);
        if( isTouching(speedBooster.class) ){
            getWorld().removeObject(booster);
            speed = 120 * speed / 100;
            MyWorld.player2Life.add(1);
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
 public void hitByProjectile1(){
        Actor projectile1 = getOneIntersectingObject(Projectile.class);
        
            if(isTouching(Projectile.class)){
                getWorld().removeObject(projectile1);
                MyWorld.player2Life.add(-1);
                
                
            }
        }
}