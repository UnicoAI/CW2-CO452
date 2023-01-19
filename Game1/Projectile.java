import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{int speed = 10;
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(){
        getImage().scale(30,30);
    }
    public void act()
    {hitEnemy();
        move(speed);
        hitprize();
         if(isTouching(Player2.class))
          getWorld().removeObject(this);
        else if(isAtEdge())
        getWorld().removeObject(this); 
        
        
       
       
        // Add your action code here.
    }
    public void hitEnemy(){
      Actor enemy1 = getOneIntersectingObject(Enemy.class);
        if( isTouching(Enemy.class))
            getWorld().removeObject(enemy1);
    }
     public void hitprize(){
        Actor projectile = getOneIntersectingObject(prize.class);
        
            if(isTouching(prize.class)){
                 
                getWorld().removeObject(projectile);
                 
                
                
            }
        }
}
