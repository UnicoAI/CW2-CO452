import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shooting projectile.
 * 
 * @Marius Boncica 
 * @version (3 19/01/2023)
 */
public class Projectile extends Actor
{//declare speed value
    int speed = 10;
    /**
   *constructor
   **scale image
     */
    public Projectile(){
        getImage().scale(30,30);
    }
    /**
 * Act method: behavior of class
 * remove if touching Player2 class
 * *remove is at the edge of world or enemy
 */
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
    //remove projectil if touching Enemy class
    public void hitEnemy(){
      Actor enemy1 = getOneIntersectingObject(Enemy.class);
        if( isTouching(Enemy.class))
            getWorld().removeObject(enemy1);
    }
    //remove projectile if touching prize class
     public void hitprize(){
        Actor projectile = getOneIntersectingObject(prize.class);
        
            if(isTouching(prize.class)){
                 
                getWorld().removeObject(projectile);
                 
                
                
            }
        }
}
