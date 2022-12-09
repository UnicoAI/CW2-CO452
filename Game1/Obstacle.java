import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Test for steps project.
 * 
 * @author Marius Boncica 
 * @version (1.01 8/12/2022)
 */

public class Obstacle extends Actor
{
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count;
    String obstacleName;
    
    public Obstacle(String obstacleName)
    {
    this.obstacleName = obstacleName;
    setImage(this.obstacleName);
    getImage().scale(50,50);    }
    public void act()
    {
       
       count++;
       if(count % (Greenfoot.getRandomNumber(30) +1) == 0 && this.obstacleName != "space.jpg")
       {
        setLocation(getX() + 30, getY() );
    if(getX() == getWorld().getWidth()-1)
    setLocation(1, getY());
    }
    }
}
