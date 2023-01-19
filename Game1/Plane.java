import greenfoot.*;

public class Plane extends ScrollActors
{
    public String  PlaneImage;
     public static int score = 0, planeLife = 0, contorPrizeSound = 10, timerBoosterSound = 0, contorBoosterSound = 10;
    static int speed = 1;
      static boolean prizeSoundOn = false, boosterSoundOn = false;
    static GreenfootSound prizeSound = new GreenfootSound("cherry_sound(short_buzzer_sound).wav"), boosterSound = new GreenfootSound("burger_sound(sci_fi_drill_alert).wav");

     // current speed
     public Plane(String PlaneImage){
    this.PlaneImage = PlaneImage;

    getImage().scale(150,150);}
    public void act()
    {
        // adjusting the rotation
        
        int dr = 0;
        if (Greenfoot.isKeyDown("right")) dr++;
        if (Greenfoot.isKeyDown("left")) dr--;
        turn(dr*QVAL);
        // adjusting the speed
        int ds = 0;
        if (Greenfoot.isKeyDown("up")) ds++;
        if (Greenfoot.isKeyDown("down")) ds--;
        speed += ds;
        // limiting the speed
        if (speed < 0) speed = 0;
        if (speed > 5*QVAL) speed = 5*QVAL;
        // moving
        move(speed);
      
         removePoints();
        fireProjectile();
        addPoints();
        
       
    }
     public void fireProjectile(){
        if(Greenfoot.mousePressed(null)){
             Projectile projectile = new Projectile();
            getWorld().addObject(projectile,getX(),getY());
               projectile.turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    
    }
    }
     private void addPoints(){
        Actor points = getOneIntersectingObject(Earth.class);
         
        if( isTouching(Earth.class) ){
             
                score++;
             
            
}Actor points2 = getOneIntersectingObject(Mars.class);
    if( isTouching(Mars.class) ){
            
                score++;
                
            
}
}
private void removePoints(){
        Actor points = getOneIntersectingObject(Sun.class);
        if( isTouching(Sun.class ) ){
           
                score--;
                      
        setRotation(getRotation()+40);
        
            
}
 Actor points2 = getOneIntersectingObject(Enemy.class);
        if( isTouching(Enemy.class ) ){
            
                score--;
               
            
}
}

}

