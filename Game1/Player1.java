import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Author: Marius Daniel Boncica- Group project
 * UPDATE 14/12/2022
 */
public class Player1 extends Actor
{
    public static int scor = 0, cadran = 1,  timerPrizeSound = 0, contorPrizeSound = 10, timerBoosterSound = 0, contorBoosterSound = 10;
    static float speed = 1;
    static boolean prizeSoundOn = false, boosterSoundOn = false;
    static GreenfootSound prizeSound = new GreenfootSound("cherry_sound(short_buzzer_sound).wav"), boosterSound = new GreenfootSound("burger_sound(sci_fi_drill_alert).wav");
    public void act() 
    {
        control();
        addPoints();
        speedBooster();
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
            
            MyWorld world = (MyWorld) getWorld();
            switch(cadran)
            {
                case 1:
                    if( points.getX() >= world.the_width/2 && points.getY() <= world.the_height/2 ) scor += 2;
                    break;
                case 2:
                    if( points.getX() <= world.the_width/2 && points.getY() <= world.the_height/2 ) scor += 2;
                    break;
                case 3:
                    if( points.getX() <= world.the_width/2 && points.getY() >= world.the_height/2 ) scor += 2;
                    break;
                case 4:
                    if( points.getX() >= world.the_width/2 && points.getY() >= world.the_height/2 ) scor += 2;
                    break;
             }
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
    private void speedBooster(){
        Actor booster = getOneIntersectingObject(speedBooster.class);
        if( isTouching(speedBooster.class) ){
            getWorld().removeObject(booster);
            speed = 120 * speed / 100;
            
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
