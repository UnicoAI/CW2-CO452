import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Author Marius Daniel Boncica
 * updated 14/12/2022
 */
public class prize extends Actor
{GifImage myGif = new GifImage("satelit.gif");
    int speed = 3;
    public void act() 
    {
        move(speed);
       if(isAtEdge()) turn(20);
      hitByProjectile1();
      hitByProjectile2();
    } 
   
     public void hitByProjectile2(){
        Actor projectile2 = getOneIntersectingObject(Projectile2.class);
        
            if(isTouching(Projectile2.class)){
                getWorld().removeObject(projectile2);
                MyWorld.player2Life.add(1);
                
                
            }
        }
        public void hitByProjectile1(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        
            if(isTouching(Projectile.class)){
                getWorld().removeObject(projectile);
                MyWorld.player1Life.add(1);
                Single.playerSingleLife.add(1);
                 
            }
        }
}
