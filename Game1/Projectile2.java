import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * shooting projectile
 * 
 * @Marius Boncica
 * @ version 319/01/2023
 */
public class Projectile2 extends Actor
{//declare variable speed and set value to 10
    int speed = 10;
    /**
*constructor
 * scale image
     */
    public Projectile2(){
        getImage().scale(30,30);
    }
    /**
 * Act Method
 * move,remove projectile when touching edge, player1 clas, prize class
 */
    public void act()
    {turnProjectile();
        move(speed);
        hitprize(); 
         if(isAtEdge()) move(0);
        if(isTouching(Player1.class))
          getWorld().removeObject(this);
                 
            
       
       
        

    }
    public void turnProjectile(){
      
    }
    //method to remove projectile if touching prize class
    public void hitprize(){
        Actor projectile2 = getOneIntersectingObject(prize.class);
        
            if(isTouching(prize.class)){
                 
                getWorld().removeObject(projectile2);
                 
                
                
            }
        }
}
