import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * update 
 * 
 * @author Marius Boncica 
 * @version (1.01 8/12/2022)
 */

public class Obstacle extends Actor
{
    /**
     * declare variables
     
     */
    int count;
    String obstacleName;
    /**
     * constructor
     * scale image
     */
    public Obstacle(String obstacleName)
    {
    this.obstacleName = obstacleName;
    setImage(this.obstacleName);
    getImage().scale(50,50);    }
    //method act for class bahaviour
    //set location random
    public void act()
    {
       
       count++;
       if(count % (Greenfoot.getRandomNumber(30) +1) == 0 && this.obstacleName != "news - Copy.gif")
       {
        setLocation(getX() + 30, getY() );
    if(getX() == getWorld().getWidth()-1)
    setLocation(1, getY());
    }
    }
}
