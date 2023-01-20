import greenfoot.*;
/**
 * Author: Marius Daniel Boncica- Group project
 * UPDATE 19/01/2023
 */
public class Plane extends ScrollActors
{//declare variables score, prizecount booster speed
    //sound event
    public String  PlaneImage;
     public static int score = 0, planeLife = 0, contorPrizeSound = 10, timerBoosterSound = 0, contorBoosterSound = 10;
    static int speed = 1;
      static boolean prizeSoundOn = false, boosterSoundOn = false;
    static GreenfootSound prizeSound = new GreenfootSound("cherry_sound(short_buzzer_sound).wav"), boosterSound = new GreenfootSound("burger_sound(sci_fi_drill_alert).wav");

     // constructor: scale image
     public Plane(String PlaneImage){
    this.PlaneImage = PlaneImage;

    getImage().scale(150,150);}
    /**
 * Act Method
 * Control behaviour using arrows
 * add points, shooting
 */
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
        removeSun();
        
       
    }
    //method to shoot- create object of projectile class
     public void fireProjectile(){
        if(Greenfoot.mousePressed(null)){
             Projectile projectile = new Projectile();
            getWorld().addObject(projectile,getX(),getY());
               projectile.turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    
    }
    }
    //method to add points if touching Earth and Mars class
     private void addPoints(){
        Actor points = getOneIntersectingObject(Earth.class);
         
        if( isTouching(Earth.class) ){
             
                score++;
             
            
}Actor points2 = getOneIntersectingObject(Mars.class);
    if( isTouching(Mars.class) ){
            getWorld().removeObject(points2);
                score++;
                
            
}
}
//method to remove points if touching Sun class or Enemy Class
private void removePoints(){
        Actor points = getOneIntersectingObject(Sun.class);
        if( isTouching(Sun.class ) ){
           getWorld().showText("Avoid Sun! You Will Melt!!!Press SPACEBAR",100,400);
             score--;   
                      
        setRotation(getRotation()+40);//set rotation when touching Sun class
        //score will decrease as long as plane will rotate near Sun class
            
}
 Actor points2 = getOneIntersectingObject(Enemy.class);
        if( isTouching(Enemy.class ) ){
            
                score--;//decrease score
               //score will decrease as long as Enemy rotates around Plane
            
}
}
// remove sun if score > 10
 private void removeSun(){
        Actor sun1 = getOneIntersectingObject(Sun.class);
            if ( Greenfoot.isKeyDown("space") ){
          
                getWorld().removeObject(sun1);
               getWorld().showText("Sun Removed!!!", 400, 400);
            
        }
    }

}

