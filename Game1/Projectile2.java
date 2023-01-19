import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile2 extends Actor
{int speed = 10;
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile2(){
        getImage().scale(30,30);
    }
    public void act()
    {turnProjectile();
        move(speed);
        hitprize(); 
         if(isAtEdge()) move(0);
        if(isTouching(Player1.class))
          getWorld().removeObject(this);
                 
            
       
       
        
        
        // Add your action code here.
    }
    public void turnProjectile(){
      
    }
    public void hitprize(){
        Actor projectile2 = getOneIntersectingObject(prize.class);
        
            if(isTouching(prize.class)){
                 
                getWorld().removeObject(projectile2);
                 
                
                
            }
        }
}
