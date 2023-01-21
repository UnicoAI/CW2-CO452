import greenfoot.*;
/**
 * Author: Marius Daniel Boncica- Group project
 * UPDATE 19/01/2023
 */
public class Plane extends ScrollActors
{//declare variables score, prizecount booster speed
    //sound event
    public String  PlaneImage;
     public static int score = 0;
    static int speed = 1;
    
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
        if (Greenfoot.isKeyDown("d")) dr++;
        if (Greenfoot.isKeyDown("a")) dr--;
        turn(dr*QVAL);
        // adjusting the speed
        int ds = 0;
        if (Greenfoot.isKeyDown("w")) ds++;
        if (Greenfoot.isKeyDown("s")) ds--;
        speed += ds;
        // limiting the speed
        if (speed < 0) speed = 0;
        if (speed > 5*QVAL) speed = 5*QVAL;
        // moving
        move(speed);
      
         removePoints();
        fireProjectile();
        addPoints();
        asteroidRemove();
        touchAsteroid();
        removeSun();
        scoreAlert();
        asteroidRemove();
        
       
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
            
                score++;
                
            
}
}
//method to remove points if touching Sun class or Enemy Class
private void removePoints(){
        Actor points = getOneIntersectingObject(Sun.class);
        if( isTouching(Sun.class ) ){
            getWorld().showText("PRESS Q TO AVOID MELTING", 250, 250);
            score--;
             setRotation(getRotation()+40);//set rotation when touching Sun class
        //score will decrease as long as plane will rotate near Sun class
    }
    else
    getWorld().showText("  ", 250, 250);
    
      
       
 Actor points2 = getOneIntersectingObject(Enemy.class);
        if( isTouching(Enemy.class ) ){
            
                score--;//decrease score
               //score will decrease as long as Enemy rotates around Plane
            
}
}
private void removeSun(){
    Actor remosun = getOneIntersectingObject(Sun.class);
            if ( Greenfoot.isKeyDown("q")){
          
            getWorld().removeObject(remosun);}
        }  
   private void touchAsteroid(){
            
        
        if(isTouching(Asteroid.class)){
        setRotation(getRotation()+5);}
   
       
}
//method to drop points and remove a Asteroid class when intersecting + spacebar    
     private void asteroidRemove(){
        Actor moon = getOneIntersectingObject(Asteroid.class);
            if ( (Greenfoot.isKeyDown("space")) && (score >10)){
                
            getWorld().removeObjects(getWorld().getObjects(Asteroid.class));
            
                 getWorld().showText("ASTEROID DESTROYED!!!YOU SAVED THE WORLD!!!", 550, 400);
            getWorld().showText("KILL MORE INVADERS", 450, 500);}
            else
            getWorld().showText("  ", 550, 400);
            }
        
            public void scoreAlert(){
                if(isTouching(Asteroid.class) && score>=10)
                 getWorld().showText("TOUCH AND PRESS SPACEBAR TO REMOVE ASTEROID", 350, 250);
            
            else if(isTouching(Asteroid.class) && score<=10)
             getWorld().showText("YOU NEED 10 POINTS TO REMOVE ASTEROID", 350, 250);
             else
             getWorld().showText("  ", 350, 250);
            
        }
    }
        


